package com.context;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
