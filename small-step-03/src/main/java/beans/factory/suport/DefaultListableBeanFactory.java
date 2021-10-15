package beans.factory.suport;


import beans.BeansException;
import beans.factory.factory.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class DefaultListableBeanFactory
        extends AbstractAutowireCapableBeanFactory
        implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("no bean named " + beanName + " is defined");
        }
        return beanDefinition;
    }
}
