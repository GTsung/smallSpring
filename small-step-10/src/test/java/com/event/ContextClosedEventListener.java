package com.event;

import com.context.ApplicationListener;
import com.context.event.ContextClosedEvent;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
