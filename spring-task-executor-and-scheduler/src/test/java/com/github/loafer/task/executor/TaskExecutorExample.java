package com.github.loafer.task.executor;

import org.springframework.core.task.TaskExecutor;

/**
 * @author zhaojh.
 */
public class TaskExecutorExample {
    private class PrintMessageTask implements Runnable{
        private String message;

        private PrintMessageTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }

    private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages(){
        for (int i=1; i<40; i++){
            taskExecutor.execute(new PrintMessageTask("Message " + i));
        }
    }
}
