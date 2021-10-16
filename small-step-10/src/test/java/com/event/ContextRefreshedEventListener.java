package com.event;

import com.context.ApplicationListener;
import com.context.event.ContextRefreshedEvent;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
