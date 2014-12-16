package com.github.loafer.hello.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhaojh.
 */
public class NiHaoEvent extends ApplicationEvent {
    public NiHaoEvent(String message) {
        super(message);
    }
}
