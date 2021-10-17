package com.home.beans.factory;

import com.home.beans.BeansException;
import com.home.beans.factory.factory.AutowireCapableBeanFactory;
import com.home.beans.factory.factory.BeanDefinition;
import com.home.beans.factory.factory.BeanPostProcessor;
import com.home.beans.factory.factory.ConfigurableBeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory,
        AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
