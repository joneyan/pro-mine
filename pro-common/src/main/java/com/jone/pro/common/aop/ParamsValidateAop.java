package com.jone.pro.common.aop;

import com.jone.pro.common.base.ParamsObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjing
 * @Date: 2019/4/17 下午6:25
 * @Description:
 */
@Aspect
@Component
public class ParamsValidateAop {
    @Pointcut("@annotation(com.jone.pro.common.annotation.ParamsValidate)")
    public void controllerAspect() {
        System.out.println("========进入ParamsValidateAop=========");
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length>0){
            for (Object item : args) {
                if (ParamsObject.class.isAssignableFrom(item.getClass())) {
                    ParamsObject paramsObject =(ParamsObject) item;
                    paramsObject.validate();
                }
            }
        }
    }
}
