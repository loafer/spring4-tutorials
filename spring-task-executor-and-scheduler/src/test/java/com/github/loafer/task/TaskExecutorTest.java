package com.github.loafer.task;

import com.github.loafer.task.executor.TaskExecutorExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config-threadPoolTaskExecutor.xml"})
public class TaskExecutorTest {

    @Resource
    private TaskExecutorExample taskExecutorExample;

    @Test
    public void testTaskExecutorExample(){
        taskExecutorExample.printMessages();
    }
}
