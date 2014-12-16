package com.github.loafer.hello.listener;

import com.github.loafer.hello.HelloEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhaojh.
 */
@Component
public class LisiListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof HelloEvent){
            String message = String.format("李四收到了消息:%s", event.getSource());
            System.out.println(message);
        }
    }
}
