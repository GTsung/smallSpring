package com.context;

import com.home.beans.BeansException;
import com.home.beans.factory.Aware;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
