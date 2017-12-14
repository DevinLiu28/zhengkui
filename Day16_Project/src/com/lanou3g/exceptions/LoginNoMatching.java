package com.lanou3g.exceptions;

public class LoginNoMatching extends Exception {
    @Override
    public String getMessage() {
        return "用户名或密码错误;请重新输入";
    }
}
