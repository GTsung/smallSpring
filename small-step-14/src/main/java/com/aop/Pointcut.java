package com.aop;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
