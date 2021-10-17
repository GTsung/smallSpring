package com.aop;

import org.aopalliance.aop.Advice;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public interface Advisor  {
    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
