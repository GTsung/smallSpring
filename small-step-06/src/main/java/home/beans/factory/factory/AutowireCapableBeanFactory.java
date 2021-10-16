package home.beans.factory.factory;

import home.beans.BeansException;
import home.beans.factory.BeanFactory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行beanPostProcessors接口实现类的postProcessorBeforeInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行beanPostProcessors接口实现类的postProcessorAfterInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
