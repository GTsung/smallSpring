package com.bean;

import com.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public class SpouseAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口(切面)：" + method);
    }
}
