package com.aop;

import java.lang.reflect.Method;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
