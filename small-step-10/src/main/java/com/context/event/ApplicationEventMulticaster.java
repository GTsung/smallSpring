package com.context.event;

import com.context.ApplicationEvent;
import com.context.ApplicationListener;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
