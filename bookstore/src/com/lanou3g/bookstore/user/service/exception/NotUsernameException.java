package com.lanou3g.bookstore.user.service.exception;

public class NotUsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名不能为空,请重新注册";
    }
}
