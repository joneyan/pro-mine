package com.jone.pro.common.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/12/3 下午6:12
 * @Description:
 */
public class WxNewsContentVo implements Serializable {
    private List<WxMediaNewsVo> news_item;

    private Date create_time;

    private Date update_time;

    public List<WxMediaNewsVo> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<WxMediaNewsVo> news_item) {
        this.news_item = news_item;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
