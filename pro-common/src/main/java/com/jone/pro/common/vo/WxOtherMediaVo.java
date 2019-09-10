package com.jone.pro.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yanjing
 * @Date: 2018/11/29 上午11:56
 * @Description:
 */
public class WxOtherMediaVo implements Serializable {
    private String media_id;
    private String name;
    private Date update_time;
    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
