package com.jone.pro.admin.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2019/4/9 下午3:10
 * @Description:
 */
@Document(indexName = "my",type = "doc",indexStoreType = "fs" , shards = 5,replicas = 1,refreshInterval = "-1")
public class Pepole implements Serializable {
    private Long id;

    private String name;

    private Integer old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
