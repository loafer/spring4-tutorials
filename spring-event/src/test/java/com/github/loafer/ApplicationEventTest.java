package com.github.loafer;

import com.github.loafer.hello.HelloEvent;
import com.github.loafer.hello.listener.NiHaoEvent;
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
public class ApplicationEventTest {

    @Resource
    private ApplicationContext context;

    @Test
    public void testPublishEvent(){
        for (int i=1; i<2; i++){
            String header = String.format("========= publish %d ==========", i);
            System.out.println(header);
            context.publishEvent(new HelloEvent("Hello world."));
        }
    }

    @Test
    public void testOrderReceived(){
        for (int i=1; i<2; i++){
            String header = String.format("========= order received ==========", i);
            System.out.println(header);
            context.publishEvent(new NiHaoEvent("你好."));
        }
    }
}
