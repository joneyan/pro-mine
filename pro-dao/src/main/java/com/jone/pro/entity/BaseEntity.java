package com.jone.pro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2019/7/11 14:08
 */
@Data
public class BaseEntity implements Serializable {
    @TableField("deleted")
    private Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public BaseEntity setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
