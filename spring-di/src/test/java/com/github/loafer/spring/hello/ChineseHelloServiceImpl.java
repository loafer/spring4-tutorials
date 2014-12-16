package com.github.loafer.spring.hello;

import org.springframework.stereotype.Component;

/**
 * Created by zhaojh on 14-9-18.
 */
@Component("chinese")
public class ChineseHelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "你好！";
    }
}
