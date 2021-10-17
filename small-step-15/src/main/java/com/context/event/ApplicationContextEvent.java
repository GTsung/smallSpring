package com.context.event;

import com.context.ApplicationContext;
import com.context.ApplicationEvent;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
