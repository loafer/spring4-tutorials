package com.github.loafer.spring.dependencies.lookupmethod;

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
@ContextConfiguration({"/spring-lookupmethod.xml"})
public class TestMachine {

    @Resource
    private ApplicationContext context;

    @Test
    public void testLookupMethod(){
        Machine machine = (Machine) context.getBean("machine");
        Life life = machine.createlife();
        life.hello();
    }
}
