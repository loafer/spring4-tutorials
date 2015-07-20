package com.github.loafer.spring.mvc.exceptions;

/**
 * @author zhaojh.
 */
public class BizException extends RuntimeException{
    private String code;
    private Object[] args;

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.code = message;
    }

    public BizException(String message) {
        this(message, null, null);
    }

    public BizException(String message, Object[] args){
        this(message, args, null);
    }

    public BizException(String message, Object[] args, Throwable cause){
        super(message, cause);
        this.code = message;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }
}
