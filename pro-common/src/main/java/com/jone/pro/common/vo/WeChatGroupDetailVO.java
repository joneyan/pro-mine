package com.jone.pro.common.vo;


import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2018/11/20 下午3:09
 * @Description:
 */
public class WeChatGroupDetailVO implements Serializable {

    private Integer groupId;

    private String groupName;

    private Integer count;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
