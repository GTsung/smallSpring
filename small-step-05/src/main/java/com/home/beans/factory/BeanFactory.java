package com.home.beans.factory;


import com.home.beans.BeansException;

public interface BeanFactory {

    // 获取bean
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
