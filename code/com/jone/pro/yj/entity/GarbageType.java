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
public class GarbageType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String typeName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GarbageType{" +
        "id=" + id +
        ", typeName=" + typeName +
        "}";
    }
}
