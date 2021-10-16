package home.beans.factory.suport;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import home.beans.BeansException;
import home.beans.PropertyValue;
import home.beans.PropertyValues;
import home.beans.factory.DisposableBean;
import home.beans.factory.InitializingBean;
import home.beans.factory.factory.AutowireCapableBeanFactory;
import home.beans.factory.factory.BeanDefinition;
import home.beans.factory.factory.BeanPostProcessor;
import home.beans.factory.factory.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public abstract class AbstractAutowireCapableBeanFactory
        extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
            throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 给bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行bean的初始化方法和beanPostProcessor的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("bean实例化失败", e);
        }

        // 注册实现了DisposableBean的接口的Bean对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        // 添加到单例bean容器
        addSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 执行beanPostProcessor前置方法
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "]failed", e);
        }
        // 执行后置方法
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;

        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;

        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 如果bean实现了InitializingBean接口，则调用初始化方法
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("could not find an init method named " + initMethodName);
            }
            initMethod.invoke(bean);
        }
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("error setting property value", e);
        }
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            if (null != args && c.getParameters().length == args.length) {
                constructor = c;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
