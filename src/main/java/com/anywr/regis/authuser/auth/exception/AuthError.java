package com.anywr.regis.authuser.auth.exception;

public class AuthError {

    private final String message;

    public AuthError(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
