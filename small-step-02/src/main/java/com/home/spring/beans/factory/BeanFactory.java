package com.home.spring.beans.factory;

import com.home.spring.beans.BeansException;

public interface BeanFactory {

    // 获取bean
    Object getBean(String beanName) throws BeansException;
}
