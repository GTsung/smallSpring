package com;

import com.bean.IUserService;
import com.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public class ApiTest {

    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
