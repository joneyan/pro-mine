package com.jone.pro.common.enums;

/**
 * 导出类型
 */
public enum ExportEnums {
    ;

    private Integer code;
    private String rptModelName;
    private String groupName;

    ExportEnums(Integer code, String rptModelName, String groupName) {
        this.code = code;
        this.rptModelName = rptModelName;
        this.groupName = groupName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRptModelName() {
        return rptModelName;
    }

    public void setRptModelName(String rptModelName) {
        this.rptModelName = rptModelName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
