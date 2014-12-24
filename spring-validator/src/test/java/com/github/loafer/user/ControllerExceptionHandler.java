package com.github.loafer.user;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author zhaojh.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseResult processBindException(HttpServletRequest request, BindException ex){
        String url = request.getRequestURL().toString();

        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        for (FieldError fieldError : fieldErrors){
            String msg = String.format("field: [%s], message: %s", fieldError.getField(), fieldError.getDefaultMessage());
            System.out.println(msg);
            message.append(",").append(fieldError.getDefaultMessage());
        }

        return new ResponseResult(false, url, message.length()>1 ? message.toString().substring(1) : "binding errors.");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseResult processConstraintViolationException(HttpServletRequest request, ConstraintViolationException ex){
        String url = request.getRequestURL().toString();

        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        for (ConstraintViolation constraintViolation : constraintViolations){
            System.out.println(constraintViolation.getMessage());
            message.append(",").append(constraintViolation.getMessage());
        }
        return new ResponseResult(false, url, message.length()>1 ? message.toString().substring(1) : "error");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult processException(HttpServletRequest request, Exception ex){
        String url = request.getRequestURL().toString();

        System.out.println(ex);

        return new ResponseResult(false, url, ex.getMessage());
    }
}
