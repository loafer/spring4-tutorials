package com.github.loafer.spring.hello;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhaojh
 */
@Component
public class Person {

    @Resource(name = "english")
    private HelloService helloService;

    public void sayHello(){
        System.out.println(helloService.say());
    }
}
