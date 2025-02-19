package com.cxzcanying.winterproject.pojo;

import com.cxzcanying.winterproject.exception.DuplicateIsbnException;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Result<?>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Result<?> result = Result.fail(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateIsbnException.class)
    public ResponseEntity<Result<?>> handleDuplicateISBNException(DuplicateIsbnException ex) {
        Result<?> result = Result.fail(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result<?>> handleValidationException(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            errors.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                message.append(fieldError.getDefaultMessage()).append("; ");
            });
        }
        Result<?> result = Result.fail(400, message.length() > 0 ? message.toString() : "请求参数错误");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<?>> handleException(Exception e) {
        log.error("系统异常", e);
        String errorMessage = "系统异常，请稍后重试";
        Result<?> result = Result.fail(500, errorMessage);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
