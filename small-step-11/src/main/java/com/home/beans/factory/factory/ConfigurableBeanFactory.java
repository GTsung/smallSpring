package com.home.beans.factory.factory;


import com.home.beans.factory.HierarchicalBeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
