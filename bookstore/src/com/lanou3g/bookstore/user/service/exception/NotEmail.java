package com.lanou3g.bookstore.user.service.exception;

public class NotEmail extends UserException {
    @Override
    public String getMessage() {
        return "邮箱不能为空;请重新注册";
    }
}
