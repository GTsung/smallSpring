package com.home.spring.beans;

import com.home.spring.beans.factory.factory.BeanDefinition;
import com.home.spring.beans.factory.suport.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService", beanDefinition);
        UserService u1 = (UserService) factory.getBean("userService");
        u1.queryUserInfo();
        UserService u2 = (UserService) factory.getBean("userService");
        u2.queryUserInfo();
    }
}
