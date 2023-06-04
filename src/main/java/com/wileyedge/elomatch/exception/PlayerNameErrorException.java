package com.wileyedge.elomatch.exception;

public class PlayerNameErrorException extends Exception {

    public PlayerNameErrorException(String message) {

        super(message);
    }
    public PlayerNameErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}