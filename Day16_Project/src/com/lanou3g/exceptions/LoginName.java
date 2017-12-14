package com.lanou3g.exceptions;

public class LoginName extends Exception {
    @Override
    public String getMessage() {
        return "昵称必须全英文";
    }
}
