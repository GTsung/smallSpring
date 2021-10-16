package com.home.beans.factory;

import com.home.beans.BeansException;

public interface BeanFactoryAware extends Aware {

    // 感知到beanFactory
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
