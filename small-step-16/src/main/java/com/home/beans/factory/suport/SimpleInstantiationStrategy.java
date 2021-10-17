package com.home.beans.factory.suport;


import com.home.beans.BeansException;
import com.home.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName,
                              Constructor constructor, Object[] args)
            throws BeansException {

        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (null != constructor) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance(args);
            }
        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("failed to instantiate[" + beanClass + "]");
        }
    }
}
