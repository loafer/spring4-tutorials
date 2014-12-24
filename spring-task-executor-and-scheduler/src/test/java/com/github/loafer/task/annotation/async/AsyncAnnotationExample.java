package com.github.loafer.task.annotation.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author zhaojh.
 */
@Component
public class AsyncAnnotationExample {
    @Async
    public void sayHelloWorld() throws InterruptedException {
        System.out.println("hello world.");
        Thread.sleep(1000);
    }

    @Async
    public void sayNiHao(String name){
        System.out.println(String.format("你好， %s", name));
    }

    @Async
    public Future<String> saySorry(final String name){
        return new AsyncResult<String>(String.format("Sorry, %s", name));
    }

    @Async
    public Future<String> sayHuoXingYu(){
        throw new RuntimeException("听不懂");
    }

    @Async
    public void divideByZero(int n){
        int i = n/0;
    }
}
