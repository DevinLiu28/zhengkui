package com.lanou3g.bookstore.user.service.exception;

public class RepetitiveEmainException extends UserException {
    @Override
    public String getMessage() {
        return "重复的邮箱;请重新输入";
    }
}
