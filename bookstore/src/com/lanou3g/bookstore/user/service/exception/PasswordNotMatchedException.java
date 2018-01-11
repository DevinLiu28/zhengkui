package com.lanou3g.bookstore.user.service.exception;

public class PasswordNotMatchedException extends UserException {
    @Override
    public String getMessage() {
        return "密码错误,请重新输入";
    }
}
