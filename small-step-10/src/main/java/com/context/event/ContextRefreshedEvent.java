package com.context.event;

/**
 * 事件，关闭刷新
 * @author GTsung
 * @date 2021/10/16
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
