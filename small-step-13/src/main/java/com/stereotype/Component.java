package com.stereotype;

import java.lang.annotation.*;

/**
 * @author GTsung
 * @date 2021/10/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
