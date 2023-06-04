package com.wileyedge.elomatch.exception;

public class NoEloNumberException extends Exception {

    public NoEloNumberException(String message) {

        super(message);
    }
    public NoEloNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}