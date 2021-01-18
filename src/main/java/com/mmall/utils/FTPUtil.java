package com.mmall.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 19:11 2021/1/18
 * @Modified By:
 **/
@Component
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);
    //ftp服务器地址
    @Value("${ftp.server.ip}")
    private static String hostname;

    //ftp服务器端口
    @Value("${ftp.server.port}")
    private static int port;

    //ftp登录账号
    @Value("${ftp.username}")
    private static String username;

    //ftp登录密码
    @Value("${ftp.password}")
    private static String password;

    FTPClient ftpClient = new FTPClient();

    public FTPUtil(String hostname, int port, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }


    public static Boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(hostname, port, username, password);
        logger.info("开始连接服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("结束上传, 上传结果{}", result);
        return result;
    }

    private Boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;

        // 连接FTP服务器 初始化服务器
        if (connectServer(this.hostname, this.port, this.username, this.password)){
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                // 设置文件缓存
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                // 设置文件类型 设置成二进制码  防止乱码
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.setDataTimeout(1000 * 120);//设置连接超时时间
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList){
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                uploaded = false;
            } finally {
                // 释放连接
                fis.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    // 封装连接服务器方法
    private boolean connectServer(String ip, int port, String username, String password){

        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(username, password);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }

}
