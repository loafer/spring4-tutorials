package com.github.loafer.spring.container.extension.points;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhaojh.
 */
@Component("exampleBeanOne")
public class ExampleBean implements InitializingBean{

    public void init(){
        System.out.println("customer init");
    }

    @PostConstruct
    public void startup(){
        System.out.println("PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
