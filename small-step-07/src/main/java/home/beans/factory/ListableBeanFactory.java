package home.beans.factory;

import home.beans.BeansException;

import java.util.Map;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回bean
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表所有bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
