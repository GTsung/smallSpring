package com.home.spring.beans.factory.suport;

import com.home.spring.beans.BeansException;
import com.home.spring.beans.factory.BeanFactory;
import com.home.spring.beans.factory.factory.BeanDefinition;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
