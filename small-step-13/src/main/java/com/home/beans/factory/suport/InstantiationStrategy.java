package com.home.beans.factory.suport;


import com.home.beans.BeansException;
import com.home.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor constructor, Object[] args) throws BeansException;
}
