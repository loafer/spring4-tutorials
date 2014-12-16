package com.github.loafer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config-hibernate-jpa.xml")
//@ContextConfiguration("/spring-config-eclipselink-jpa.xml")
public class SpringJPATest {

    @Test
    public void test(){
        System.out.println("start.");
    }
}
