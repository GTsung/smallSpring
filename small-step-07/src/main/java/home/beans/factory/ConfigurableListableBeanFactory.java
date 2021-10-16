package home.beans.factory;

import home.beans.BeansException;
import home.beans.factory.factory.AutowireCapableBeanFactory;
import home.beans.factory.factory.BeanDefinition;
import home.beans.factory.factory.BeanPostProcessor;
import home.beans.factory.factory.ConfigurableBeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory,
        AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
