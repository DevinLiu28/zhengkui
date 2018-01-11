package com.lanou3g.bookstore.user.service.exception;

public class NonactivatedException extends UserException {
    @Override
    public String getMessage() {
        return "账号未激活;请确认邮件激活后再登录";
    }
}
