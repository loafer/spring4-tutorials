package com.github.loafer;

import com.github.loafer.upm.users.entity.Action;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config-eclipselink-jpa.xml")
public class EclipseLinkTest {
    private static final String PERSISTENCE_UNIT_NAME = "eclipselinkUnit";
    private static EntityManagerFactory factory;


    @Test
    public void testNativeAPI(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
    }

    @Test
    public void testSpringJPA(){

    }
}
