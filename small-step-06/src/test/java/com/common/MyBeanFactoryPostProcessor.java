package com.common;

import home.beans.BeansException;
import home.beans.PropertyValue;
import home.beans.PropertyValues;
import home.beans.factory.ConfigurableListableBeanFactory;
import home.beans.factory.factory.BeanDefinition;
import home.beans.factory.factory.BeanFactoryPostProcessor;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "专业操刘萧妈妈公司"));
    }
}
