package home.beans.factory;

import home.beans.BeansException;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface InitializingBean {

    /**
     * bean属性填充完毕后调用
     * @throws BeansException
     */
    void afterPropertiesSet() throws Exception;
}
