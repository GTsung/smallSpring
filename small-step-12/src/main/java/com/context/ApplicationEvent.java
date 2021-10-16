package com.context;

import java.util.EventObject;

/**
 * 事件类
 * @author GTsung
 * @date 2021/10/16
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
