package com.context;

import java.util.EventListener;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ApplicationListener<E extends ApplicationEvent>
        extends EventListener {

    void onApplicationEvent(E event);
}
