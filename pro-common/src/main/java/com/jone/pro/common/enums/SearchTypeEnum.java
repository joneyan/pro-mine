package com.jone.pro.common.enums;

/**
 * @author yanjing
 * @date 2019/7/19 9:15
 */
public enum SearchTypeEnum implements BaseEnum {
    KEY_WORD("key_word","关键词搜索"),
    TYPE_ID("type_id","类型ID搜索"),
    ;

    private String code;
    private String desc;

    SearchTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public SearchTypeEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public SearchTypeEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
