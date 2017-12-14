package com.lanou3g.exceptions;

public class LoginNoPhoneNum extends LoginException {
    @Override
    public String getMessage() {
        return "用户名必须为电话号码或邮箱";
    }
}
