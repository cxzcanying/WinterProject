package com.cxzcanying.winterproject.exception;

import lombok.Getter;

/**
 * @author 21311
 */
public class ValidationException extends RuntimeException {
    @Getter
    private int code;
    private final String message;

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