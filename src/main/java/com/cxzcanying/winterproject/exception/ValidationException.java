package com.cxzcanying.winterproject.exception;

import lombok.Getter;

public class ValidationException extends RuntimeException {
    @Getter
    private int code;
    private String message;

    public ValidationException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}