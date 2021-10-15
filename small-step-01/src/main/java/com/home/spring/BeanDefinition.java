package com.home.spring;

/**
 * Bean定义
 * @author GTsung
 * @date 2021/10/15
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
