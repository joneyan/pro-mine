package com.jone.pro.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2019/7/19 9:49
 */
@Data
public class GarbageSearchVO implements Serializable {
    private Long id;
    private String name;
    private String typeName;
    private String typeStyle;
}
