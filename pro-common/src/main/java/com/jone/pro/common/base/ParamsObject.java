package com.jone.pro.common.base;

import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2019/4/17 下午6:21
 * @Description:
 */
public abstract class ParamsObject implements Serializable {
    public ParamsObject() {
    }

    public abstract void validate();
}
