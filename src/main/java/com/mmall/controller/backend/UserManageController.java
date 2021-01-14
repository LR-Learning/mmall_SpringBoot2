package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 13:17 2021/1/13
 * @Modified By:
 **/
@RestController
@RequestMapping("/manage/user")
@ResponseBody
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()){
            User user = response.getData();
            if (user.getRole() == Const.Role.ROLE_ADMIN){
                // 说明登陆的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            } else{
                return ServerResponse.createByErrorMessage("不是管理员， 无法登录");
            }
        }
        return response;
    }
}
