package context;

import home.beans.BeansException;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
