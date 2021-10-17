package com.aop;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
