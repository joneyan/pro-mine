package com.jone.pro.yj.entity;

import BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanjing
 * @since 2019-07-11
 */
public class Garbage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 垃圾名称
     */
    private String garbageName;

    /**
     * 垃圾类型
     */
    private Long typeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Garbage{" +
        "id=" + id +
        ", garbageName=" + garbageName +
        ", typeId=" + typeId +
        "}";
    }
}
