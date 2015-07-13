package com.github.loafer.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhaojh.
 */
@Component
public class ExampleBean implements InitializingBean, DisposableBean{
    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init(){
        System.out.println("custom init.");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void cleanup(){
        System.out.println("custom cleanup");
    }
}
