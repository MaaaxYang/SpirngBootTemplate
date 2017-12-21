package com.ryan.atom.test.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/12/19.
 */
@Documented
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";

    String name() default "NameLess";
}
