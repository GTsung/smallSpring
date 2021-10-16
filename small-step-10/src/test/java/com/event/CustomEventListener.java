package com.event;

import com.context.ApplicationListener;

import java.util.Date;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "的消息，时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
