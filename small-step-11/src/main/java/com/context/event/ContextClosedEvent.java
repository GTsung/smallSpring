package com.context.event;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
