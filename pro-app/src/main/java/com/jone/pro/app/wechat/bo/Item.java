package com.jone.pro.app.wechat.bo;

import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2018/11/28 下午3:07
 * @Description:
 */
public class Item implements Serializable {
    private Article item;

    public Article getItem() {
        return item;
    }

    public void setItem(Article item) {
        this.item = item;
    }
}
