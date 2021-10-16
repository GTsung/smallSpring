package com;

import com.beans.UserService;
import com.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ApiTest {

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService u = (UserService) applicationContext.getBean("userService");
        System.out.println(u.queryUserInfo());

        System.out.println("applicationContextAware:" + u.getApplicationContext());
        System.out.println("banFactoryAware:" + u.getBeanFactory());
    }
}
