package com.user.Excep;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String s) {
        super(s);
    }
}
