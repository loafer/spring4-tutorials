package com.github.loafer.task.annotation.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaojh.
 */
@Component
public class TaskSchedulerExample {
    private DateFormat dateFormat;

    public TaskSchedulerExample() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    //    @Scheduled(fixedRate = 1000)
    public void printMessageAtFixedRate() throws InterruptedException {
        System.out.println("[" + dateFormat.format(new Date()) + "] hello world(@fixed rate).");
        Thread.sleep(3000);
    }

    @Scheduled(fixedDelay = 1000)
    public void printMessageAtFixedDelay() throws InterruptedException {
        System.out.println("[" + dateFormat.format(new Date()) + "] hello world (@fixed delay).");
        Thread.sleep(2000);
    }
}
