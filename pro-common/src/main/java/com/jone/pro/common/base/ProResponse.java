package com.jone.pro.common.base;

import com.jone.pro.common.enums.error.BaseErrorEnum;
import lombok.Data;

/**
 * @author yanjing
 * @date 2019/7/19 8:49
 */
@Data
public class ProResponse<T> {
    private T data;
    private Boolean success;
    private String msg;
    private String code;

    public static ProResponse error(BaseErrorEnum baseErrorEnum){
        ProResponse proResponse = new ProResponse();
        proResponse.success = Boolean.FALSE;
        proResponse.data = null;
        proResponse.msg = baseErrorEnum.getMsg();
        proResponse.code = baseErrorEnum.getCode();
        return proResponse;
    }

    public static ProResponse error(String msg, String code){
        ProResponse proResponse = new ProResponse();
        proResponse.success = Boolean.FALSE;
        proResponse.data = null;
        proResponse.msg = msg;
        proResponse.code = code;
        return proResponse;
    }

    public ProResponse() {
    }

    public  ProResponse(T data){
        this.data = data;
        this.success = Boolean.TRUE;
        this.code = "200";
        this.msg = "成功";
    }
}
