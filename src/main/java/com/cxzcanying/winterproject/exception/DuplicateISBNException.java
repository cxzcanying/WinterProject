package com.cxzcanying.winterproject.exception;

import lombok.Getter;

public class DuplicateISBNException extends RuntimeException {
    @Getter
    private int code;
    private String message;

    public DuplicateISBNException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }}
