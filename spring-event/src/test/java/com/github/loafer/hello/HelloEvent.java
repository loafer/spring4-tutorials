package com.github.loafer.hello;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhaojh.
 */
public class HelloEvent extends ApplicationEvent {
    public HelloEvent(final String message) {
        super(message);
    }
}
