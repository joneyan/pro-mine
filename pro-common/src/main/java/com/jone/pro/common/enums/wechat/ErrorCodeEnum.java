package com.jone.pro.common.enums.wechat;

import org.springframework.http.HttpStatus;

/**
 * @author yanjing
 * @date 2019/9/10 11:45
 */
public interface ErrorCodeEnum {

    Integer getCode();

    String getMsg();

    HttpStatus getHttpStatus();
}
