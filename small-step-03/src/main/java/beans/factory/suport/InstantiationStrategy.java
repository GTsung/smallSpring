package beans.factory.suport;

import beans.BeansException;
import beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor constructor, Object[] args) throws BeansException;
}
