package context.support;

import home.beans.BeansException;
import home.beans.factory.ConfigurableListableBeanFactory;
import home.beans.factory.suport.DefaultListableBeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public abstract class AbstractRefreshableApplicationContext
        extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
