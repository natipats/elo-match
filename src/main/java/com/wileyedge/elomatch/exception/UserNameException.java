package com.wileyedge.elomatch.exception;

public class UserNameException extends Exception {

    public UserNameException(String message) {

        super(message);
    }
    public UserNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
