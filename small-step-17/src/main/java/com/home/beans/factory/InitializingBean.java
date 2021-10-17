package com.home.beans.factory;


/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface InitializingBean {

    /**
     * bean属性填充完毕后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
