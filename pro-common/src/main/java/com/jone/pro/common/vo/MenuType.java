package com.jone.pro.common.vo;

import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2018/10/26 下午3:40
 * @Description:
 */
public class MenuType implements Serializable {

    private String menuValue;

    private String menuName;

    public String getMenuValue() {
        return menuValue;
    }

    public void setMenuValue(String menuValue) {
        this.menuValue = menuValue;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
