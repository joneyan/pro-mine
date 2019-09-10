package com.jone.pro.common.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/11/29 下午2:15
 * @Description:
 */
public class WxMediaNewsList implements Serializable {
    private Integer total_count;

    private Integer item_count;

    private List<newsItem> item;

    public static class newsItem{
        private String media_id;

        private WxNewsContentVo content;

        private Date update_time;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public WxNewsContentVo getContent() {
            return content;
        }

        public void setContent(WxNewsContentVo content) {
            this.content = content;
        }

        public Date getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Date update_time) {
            this.update_time = update_time;
        }
    }

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

    public List<newsItem> getItem() {
        return item;
    }

    public void setItem(List<newsItem> item) {
        this.item = item;
    }
}
