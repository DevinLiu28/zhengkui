package com.lanou3g.bookstore.user.service.exception;

public class RepetitiveUsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名已注册,请重新注册";
    }
}
