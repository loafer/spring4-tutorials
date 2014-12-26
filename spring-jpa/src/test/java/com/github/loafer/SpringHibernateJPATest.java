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
public class SpringHibernateJPATest {

    @Test
    public void testGenerateSchema(){
        System.out.println("start.");
    }
}
