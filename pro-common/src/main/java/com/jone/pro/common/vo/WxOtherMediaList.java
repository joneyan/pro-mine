package com.jone.pro.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/11/29 下午12:00
 * @Description:
 */
public class WxOtherMediaList implements Serializable {
    private Integer total_count;

    private Integer item_count;

    private List<WxOtherMediaVo> item;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public List<WxOtherMediaVo> getItem() {
        return item;
    }

    public void setItem(List<WxOtherMediaVo> item) {
        this.item = item;
    }
}
