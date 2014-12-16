package com.github.loafer.hello.listener.order;

import com.github.loafer.hello.listener.NiHaoEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 当eventType、sourceType都匹配时接收并处理消息
 *
 * @author zhaojh.
 */
@Component(value = "zhangsan")
public class ZhangsanListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == NiHaoEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == String.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        String message = String.format("张三在李四之前收到了消息:%s", event.getSource());
        System.out.println(message);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
