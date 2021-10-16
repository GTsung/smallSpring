package home.beans.factory.suport;

import cn.hutool.core.util.StrUtil;
import home.beans.BeansException;
import home.beans.factory.DisposableBean;
import home.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        if (StrUtil.isNotEmpty(destroyMethodName)
                && !(bean instanceof DisposableBean
                && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("could not find a destroy method named " + destroyMethodName + " on a bean named " + beanName);
            }
            destroyMethod.invoke(bean);
        }
    }
}
