package com.home.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author GTsung
 * @date 2021/10/17
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
