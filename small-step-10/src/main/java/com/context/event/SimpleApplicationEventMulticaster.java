package com.context.event;

import com.context.ApplicationEvent;
import com.context.ApplicationListener;
import com.home.beans.factory.BeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
