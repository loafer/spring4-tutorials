package com.github.loafer.spring.bean.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config.xml"})
public class TestLifecycle {

    @Resource
    private ApplicationContext context;

    @Test
    public void testLifecycleOrder(){
        System.out.println("test lifecycle.");
    }
}
