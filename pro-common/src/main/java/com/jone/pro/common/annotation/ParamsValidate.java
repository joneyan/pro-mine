package com.jone.pro.common.annotation;

import org.springframework.data.elasticsearch.annotations.Document;

import java.lang.annotation.*;

/**
 * @Author: yanjing
 * @Date: 2019/4/17 下午6:12
 * @Description:
 */
@Inherited
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsValidate {
    String des() default "";
}
