package com.oles.consoleuniversity.exception;

public class NotExistException extends IllegalArgumentException {

    private static final String NOT_EXIST_EXCEPTION = "Not exist";

    public NotExistException(String message) {
        super(message.isEmpty() ? NOT_EXIST_EXCEPTION : message);
    }

}
