package com.context;


import com.home.beans.factory.HierarchicalBeanFactory;
import com.home.beans.factory.ListableBeanFactory;
import com.io.ResourceLoader;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory,
        ResourceLoader, ApplicationEventPublisher {
}
