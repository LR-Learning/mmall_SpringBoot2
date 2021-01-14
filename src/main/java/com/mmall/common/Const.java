package com.mmall.common;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 12:00 2021/1/12
 * @Modified By:
 **/
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; // 普通用户
        int ROLE_ADMIN = 1; // 管理员
    }
}
