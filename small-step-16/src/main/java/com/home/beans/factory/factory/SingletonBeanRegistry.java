package com.home.beans.factory.factory;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
