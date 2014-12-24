package com.github.loafer.user;

/**
 * @author zhaojh.
 */
public class ResponseResult {
    private boolean success;
    private String url;
    private Object message;

    public ResponseResult(boolean success) {
        this.success = success;
    }

    public ResponseResult(boolean success, String url, Object message) {
        this.success = success;
        this.url = url;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getUrl() {
        return url;
    }

    public Object getMessage() {
        return message;
    }
}
