package beans;

import beans.factory.factory.BeanDefinition;
import beans.factory.suport.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
        UserService u2 = (UserService) factory.getBean("userService", "操刘萧的妈妈");
        u2.queryUserInfo();
        System.out.println(u2.toString());
    }


    @Test
    public void testConstruct() throws Exception {
        Class<UserService> clazz = UserService.class;
        Constructor<UserService> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        UserService u = declaredConstructor.newInstance("ss");
        System.out.println(u.toString());
    }

    @Test
    public void testParamType() throws Exception {
        Class<UserService> clazz = UserService.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            UserService u;
            if (c.getParameters().length > 0) {
                u = clazz.getDeclaredConstructor(c.getParameterTypes()).newInstance("ass");
            } else {
                u = clazz.getDeclaredConstructor().newInstance();
            }
            System.out.println(u.toString());
        }
    }

    @Test
    public void testCglib() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        UserService u = (UserService) enhancer.create(new Class[]{String.class}, new Object[]{"操刘萧的媳妇"});
        System.out.println(u.toString());
    }
}
