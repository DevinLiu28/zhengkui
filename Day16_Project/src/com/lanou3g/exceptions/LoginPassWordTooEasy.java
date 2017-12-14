package com.lanou3g.exceptions;

public class LoginPassWordTooEasy extends Exception {
    @Override
    public String getMessage() {
        return "密码太简单了";
    }
}
