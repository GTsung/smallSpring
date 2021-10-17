package com.context.annotation;

import java.lang.annotation.*;

/**
 * @author GTsung
 * @date 2021/10/17
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
