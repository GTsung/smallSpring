package com.home.spring.test;

import com.home.spring.BeanDefinition;
import com.home.spring.BeanFactory;
import com.home.spring.test.bean.UserService;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
