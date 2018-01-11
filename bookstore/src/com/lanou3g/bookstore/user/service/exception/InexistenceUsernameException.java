package com.lanou3g.bookstore.user.service.exception;

public class InexistenceUsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
