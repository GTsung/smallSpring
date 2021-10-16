package com;

import com.context.support.ClassPathXmlApplicationContext;
import com.event.CustomEvent;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ApiTest {

    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
