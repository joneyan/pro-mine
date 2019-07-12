package com.jone.pro.common.annotation;

import lombok.Data;

import java.lang.annotation.*;

/**
 * @author yanjing
 * @date 2019/7/12 10:31
 */
@Inherited
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsName {
    String paramName() default "";
    String setMethodName() default "";

}
