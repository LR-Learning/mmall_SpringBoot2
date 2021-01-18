package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 18:52 2021/1/18
 * @Modified By:
 **/
public interface IFileService {

    String upload(MultipartFile file, String path);
}
