package com.jone.pro.common.enums.error;

/**
 * @author yanjing
 * @date 2019/7/19 9:38
 */
public enum BaseBizErrorEnum implements BaseErrorEnum {
    UN_KNOWN_EXCEPTION("1000","服务器发生未知错误"),
    ;
    private String code;
    private String msg;
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }

    public BaseBizErrorEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public BaseBizErrorEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    BaseBizErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
