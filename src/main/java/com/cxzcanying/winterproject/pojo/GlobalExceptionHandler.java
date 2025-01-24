package com.cxzcanying.winterproject.pojo;

import com.cxzcanying.winterproject.exception.DuplicateISBNException;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import java.util.stream.Collectors;

/**
 * @author 21311
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return Result.fail(e.getMessage());
    }
    
    @ExceptionHandler(DuplicateISBNException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleDuplicateISBNException(DuplicateISBNException e) {
        return Result.fail("ISBN已存在");
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleValidationExceptions(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return Result.fail(errorMessage);
    }
}
