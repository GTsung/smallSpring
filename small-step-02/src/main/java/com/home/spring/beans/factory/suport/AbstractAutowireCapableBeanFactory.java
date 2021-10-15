package com.home.spring.beans.factory.suport;

import com.home.spring.beans.BeansException;
import com.home.spring.beans.factory.factory.BeanDefinition;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("bean实例化失败", e);
        }
        // 添加到单例bean容器
        addSingleton(beanName, bean);
        return bean;
    }
}
