package com.example.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author zxc
 * @date 2021/4/22 11:34
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Customize {
    String value() default "logTracking";
}
