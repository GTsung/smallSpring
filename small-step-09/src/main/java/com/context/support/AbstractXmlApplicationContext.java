package com.context.support;


import com.home.beans.factory.suport.DefaultListableBeanFactory;
import com.home.beans.support.XmlBeanDefinitionReader;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public abstract class AbstractXmlApplicationContext
        extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
