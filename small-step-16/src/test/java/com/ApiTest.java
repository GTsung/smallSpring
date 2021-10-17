package com;

import com.bean.Husband;
import com.bean.Wife;
import com.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public class ApiTest {

    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
