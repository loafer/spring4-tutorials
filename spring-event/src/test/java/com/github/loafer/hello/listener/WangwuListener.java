package com.github.loafer.hello.listener;

import com.github.loafer.hello.HelloEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhaojh.
 */
@Component
public class WangwuListener implements ApplicationListener<HelloEvent> {
    @Override
    public void onApplicationEvent(HelloEvent event) {
        String message = String.format("王五收到了消息:%s", event.getSource());
        System.out.println(message);
    }
}
