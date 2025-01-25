package com.cxzcanying.winterproject.exception;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException {
    @Getter
    private int code;
    private String message;
    public ResourceNotFoundException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
