package com.jone.pro.common.enums.error;

/**
 * @author yanjing
 * @date 2019/7/19 9:41
 */
public enum  ParamsValidateErrorEnum implements BaseErrorEnum {
    SEARCH_KEY_WORD_LOSE("20001","搜索关键词缺失"),
    TYPE_ID_WORD_LOSE("20002","搜索类型缺失"),
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

    public ParamsValidateErrorEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public ParamsValidateErrorEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    ParamsValidateErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
