package com.github.loafer.spring.hello;

import org.springframework.stereotype.Component;

/**
 * @author zhaojh
 */
@Component("english")
public class EnglishHelloService implements HelloService {
    @Override
    public String say() {
        return "Hello!";
    }
}
