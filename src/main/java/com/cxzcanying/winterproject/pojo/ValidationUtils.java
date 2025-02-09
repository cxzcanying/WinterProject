package com.cxzcanying.winterproject.pojo;

import com.cxzcanying.winterproject.exception.ValidationException;

/**
 * @author 21311
 */
public class ValidationUtils {

    // 验证字符串是否为空

    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(400, fieldName + " cannot be empty");
        }
    }

    // 验证数字是否为正数

    public static void validatePositiveNumber(Number value, String fieldName) {
        if (value == null || value.doubleValue() <= 0) {
            throw new ValidationException(400, fieldName + " must be a positive number");
        }
    }

    // 验证字符串长度是否在范围内

    public static void validateStringLength(String value, String fieldName, int minLength, int maxLength) {
        if (value == null || value.length() < minLength || value.length() > maxLength) {
            throw new ValidationException(400, fieldName + " length must be between " + minLength + " and " + maxLength);
        }
    }
}