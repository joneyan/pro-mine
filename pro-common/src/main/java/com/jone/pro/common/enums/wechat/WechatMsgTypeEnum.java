package com.jone.pro.common.enums.wechat;

/**
 * @author yanjing
 * @date 2019/9/10 9:53
 */
public enum  WechatMsgTypeEnum {
    TEXT(1,"text","文字类型","textMsgReplyHandler"),
    NEWS(2,"news","图文类型",""),
    IMAGE(3,"image","图片类型",""),
    VOICE(4,"voice","语音类型",""),
    VIDEO(5,"video","视频消息",""),
    SHORT_VIDEO(6,"shortvideo","小视频",""),
    LOCATION(7,"location","定位",""),
    LINK(8,"link","链接",""),
    EVENT(9,"event","推送事件","");
    private Integer type;
    private String values;
    private String desc;
    private String handlerName;

    WechatMsgTypeEnum(Integer type, String values, String desc,String handlerName) {
        this.type = type;
        this.values = values;
        this.desc = desc;
        this.handlerName = handlerName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public WechatMsgTypeEnum setHandlerName(String handlerName) {
        this.handlerName = handlerName;
        return this;
    }

    public static WechatMsgTypeEnum getEnumByType(Integer value){
        WechatMsgTypeEnum messageTypeEnum = null;
        for(WechatMsgTypeEnum e:WechatMsgTypeEnum.values()){
            if(e.type.equals(value)){
                messageTypeEnum =e;
            }
        }
        return messageTypeEnum;
    }

    public static WechatMsgTypeEnum getEnumByValue(String value){
        WechatMsgTypeEnum messageTypeEnum = null;
        for(WechatMsgTypeEnum e:WechatMsgTypeEnum.values()){
            if(e.type.equals(value)){
                messageTypeEnum =e;
            }
        }
        return messageTypeEnum;
    }
}
