package com.home.spring.beans.factory.suport;

import com.home.spring.beans.factory.factory.BeanDefinition;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public interface BeanDefinitionRegistry {

    // 注册beanDefinition
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
