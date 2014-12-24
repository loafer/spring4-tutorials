package com.github.loafer.task.annotation.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhaojh.
 */
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        String message = String.format("调用方法[%s]出错： %s . 参数: %s", method.getName(), throwable.getMessage(), Arrays.asList(objects));
        System.out.println(message);
    }
}
