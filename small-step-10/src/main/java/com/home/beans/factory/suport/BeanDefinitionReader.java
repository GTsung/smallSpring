package com.home.beans.factory.suport;


import com.home.beans.BeansException;
import com.io.Resource;
import com.io.ResourceLoader;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;
}
