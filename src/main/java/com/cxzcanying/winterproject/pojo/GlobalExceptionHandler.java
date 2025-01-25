package com.cxzcanying.winterproject.pojo;

import com.cxzcanying.winterproject.exception.DuplicateISBNException;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import com.cxzcanying.winterproject.exception.ValidationException;
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
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 21311
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Result<?>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Result<?> result = Result.fail(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateISBNException.class)
    @ResponseBody
    public ResponseEntity<Result<?>> handleDuplicateISBNException(DuplicateISBNException ex) {
        Result<?> result = Result.fail(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) //设置状态码为 400
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String paramExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                return fieldError.getDefaultMessage();
            }
        }
        return "请求参数错误";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Result<?>> handleException(Exception ex) {
        Result<?> result = Result.fail(500, "Internal Server Error");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
