package com.jone.pro.admin.handler;

import com.jone.pro.common.base.ProResponse;
import com.jone.pro.common.enums.error.BaseBizErrorEnum;
import com.jone.pro.common.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanjing
 * @date 2019/7/19 9:27
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ProResponse handleException(Exception e){
        if (e instanceof ApplicationException){
            ApplicationException exception = (ApplicationException) e;
            return ProResponse.error(exception.getBaseErrorEnum());
        }
        return ProResponse.error(BaseBizErrorEnum.UN_KNOWN_EXCEPTION);
    }
}
