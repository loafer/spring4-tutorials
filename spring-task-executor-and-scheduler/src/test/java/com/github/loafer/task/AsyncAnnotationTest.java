package com.github.loafer.task;

import com.github.loafer.task.annotation.async.AsyncAnnotationExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config-async.xml"})
public class AsyncAnnotationTest {
    @Resource
    private AsyncAnnotationExample helloService;

    @Test
    public void testAsyncWithoutArguments() throws InterruptedException {
        helloService.sayHelloWorld();
        System.out.println("lalala~~~~~~~");
        Thread.sleep(2000);
    }

    @Test
    public void testAsyncWithArguments() throws InterruptedException {
        helloService.sayNiHao("张三");
        System.out.println("lalala~~~~~~~");
        Thread.sleep(2000);
    }

    @Test
    public void testAsyncWithReturn() throws ExecutionException, InterruptedException {
        Future<String> future = helloService.saySorry("Marry");
        System.out.println("lalala~~~~~~~");
        System.out.println(future.get());
        Thread.sleep(2000);
    }

    @Test
    public void testAsyncWithReturnAndThrowException() throws ExecutionException, InterruptedException {
        Future<String> future = helloService.sayHuoXingYu();
        System.out.println("lalala~~~~~~~");
        System.out.println(future.get());
        Thread.sleep(2000);
    }

    @Test
    public void testAsyncWithoutReturnAndThrowException() throws InterruptedException {
        helloService.divideByZero(10);
        System.out.println("lalala~~~~~~~");
        Thread.sleep(2000);
    }
}
