package com.cxzcanying.winterproject.exception;

import lombok.Getter;

/**
 * @author 21311
 */
public class DuplicateIsbnException extends RuntimeException {
    @Getter
    private int code;
    private final String message;

    public DuplicateIsbnException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }}
