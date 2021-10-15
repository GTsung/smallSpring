package com.home.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class BeanFactory {

    // 存储beanDefinition
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 获取bean
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    // 注册beanDefinition
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
