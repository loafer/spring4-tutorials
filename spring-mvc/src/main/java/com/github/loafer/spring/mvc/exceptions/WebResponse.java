package com.github.loafer.spring.mvc.exceptions;

/**
 * @author zhaojh.
 */
public class WebResponse {
    private String url;
    private String method;
    private int status;
    private String message;
    private Object data;

    public WebResponse(int status) {
        this.status = status;
    }

    public WebResponse(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public WebResponse(String url, String method, int status, String message) {
        this.url = url;
        this.method = method;
        this.status = status;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
