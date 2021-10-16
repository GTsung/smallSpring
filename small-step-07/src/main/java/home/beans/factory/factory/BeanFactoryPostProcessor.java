package home.beans.factory.factory;

import home.beans.BeansException;
import home.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface BeanFactoryPostProcessor {

    /**
     * 所有beanDefinition加载完毕后，实例化bean对象前，提供修改beanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
