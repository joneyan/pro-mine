package com.jone.pro.common.enums.wechat;

/**
 * @Author: yanjing
 * @Date: 2018/10/25 下午7:57
 * @Description:
 */
public enum EventTypeEnum {
    SUBSCRIBE("subscribe","订阅"),
    UNSUBSCRIBE("unsubscribe","取消订阅"),
    SCAN("SCAN","扫描二维码,关注时"),
    LOCATION("LOCATION","上报地理位置"),
    CLICK("CLICK","点击菜单"),
    VIEW("VIEW","点菜单链接时事件类型");
    private String type;
    private String desc;

    EventTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static  EventTypeEnum getByType(String type){
        EventTypeEnum eventTypeEnum = null;
        for(EventTypeEnum item : EventTypeEnum.values()){
            if(item.type.equals(type)){
                eventTypeEnum = item;
            }
        }
        return eventTypeEnum;
    }
}
