package com;

import com.bean.UserService;
import com.common.MyBeanFactoryPostProcessor;
import com.common.MyBeanPostProcessor;
import context.support.ClassPathXmlApplicationContext;
import home.beans.factory.suport.DefaultListableBeanFactory;
import home.beans.support.XmlBeanDefinitionReader;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ApiTest {

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-post.xml");
        UserService u = applicationContext.getBean("userService", UserService.class);
        System.out.println(u.queryUserInfo());
    }

    @Test
    public void testXml2() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // BeanDefinition加载完毕后，bean实例化前修改beanDefinition属性
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(factory);

        // Bean实例化后修改bean属性
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        factory.addBeanPostProcessor(beanPostProcessor);

        UserService u = factory.getBean("userService", UserService.class);
        System.out.println(u.queryUserInfo());
    }
}
