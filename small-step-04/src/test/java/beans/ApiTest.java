package beans;

import beans.factory.factory.BeanDefinition;
import beans.factory.factory.BeanReference;
import beans.factory.suport.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // userService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registerBeanDefinition("userService", beanDefinition);
        UserService u2 = (UserService) factory.getBean("userService");
        u2.queryUserInfo();
    }

}
