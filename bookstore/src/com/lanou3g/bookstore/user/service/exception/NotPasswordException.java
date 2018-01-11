package com.lanou3g.bookstore.user.service.exception;

public class NotPasswordException extends UserException {
    @Override
    public String getMessage() {
        return "密码不能为空,请重新注册";
    }
}
