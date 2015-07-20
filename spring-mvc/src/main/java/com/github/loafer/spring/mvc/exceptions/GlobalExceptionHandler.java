package com.github.loafer.spring.mvc.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author zhaojh.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    private MessageSource messageSource;

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public WebResponse handleBusinessException(HttpServletRequest request, BizException ex){
        String uri = request.getRequestURL().toString();
        String message = messageSource.getMessage(ex.getCode(), ex.getArgs(), request.getLocale());
        String method = request.getMethod();
        return new WebResponse(uri, method, 500, message);

    }
}
