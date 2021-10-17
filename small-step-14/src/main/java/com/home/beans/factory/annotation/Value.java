package com.home.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author GTsung
 * @date 2021/10/17
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
