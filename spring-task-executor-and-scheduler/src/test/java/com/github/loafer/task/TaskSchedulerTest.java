package com.github.loafer.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config-scheduler.xml"})
public class TaskSchedulerTest {
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000 * 10);
    }
}
