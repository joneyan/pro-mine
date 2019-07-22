package com.jone.pro.common.exception;

import com.jone.pro.common.enums.error.BaseErrorEnum;
import lombok.Data;

/**
 * @author yanjing
 * @date 2019/7/19 9:21
 */
@Data
public class ApplicationException extends RuntimeException{
    private BaseErrorEnum baseErrorEnum;

    public ApplicationException() {
    }

    public ApplicationException(BaseErrorEnum baseErrorEnum) {
        this.baseErrorEnum = baseErrorEnum;
    }
}
