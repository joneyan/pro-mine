package com.jone.pro.common.enums.wechat;

/**
 * @Author: yanjing
 * @Date: 2018/10/26 下午1:58
 * @Description:
 */
public enum WxApiUrlEnum {
    ADD_FOREVER_OTHER_MATERIAL(9001,"https://api.weixin.qq.com/cgi-bin/material/add_material","POST","新增其他类型永久素材"),
    ADD_FOREVER_NEWS_MATERIAL(9002,"https://api.weixin.qq.com/cgi-bin/material/add_news","POST","新增永久图文素材"),
    GET_FOREVER_MATERIAL(9003,"https://api.weixin.qq.com/cgi-bin/material/get_material","POST","获取永久图文素材"),
    TAG_CREATE(9004,"https://api.weixin.qq.com/cgi-bin/tags/create","POST","创建标签"),
    TAG_GET(9005,"https://api.weixin.qq.com/cgi-bin/tags/get","GET","获取标签列表"),
    TAG_UPDATE(9006,"https://api.weixin.qq.com/cgi-bin/tags/get","POST","修改标签"),
    TAG_DELETE(9007,"https://api.weixin.qq.com/cgi-bin/tags/delete","POST","删除标签"),
    TAG_FANS(9008,"https://api.weixin.qq.com/cgi-bin/user/tag/get","GET","标签下粉丝"),
    TAG_ADD_ON_USERS(9009,"https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging","POST","批量给用户打标签"),
    TAG_DEL_ON_USERS(9010,"https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging","POST","批量为用户取消标签"),
    TAG_ON_USER(9011,"https://api.weixin.qq.com/cgi-bin/tags/getidlist","POST","获取用户身上的标签"),
    USER_BASE_INFO(9012,"https://api.weixin.qq.com/cgi-bin/user/info","GET","获取用户基本信息"),
    USERS_BASE_INFO(9013,"https://api.weixin.qq.com/cgi-bin/user/info/batchget","POST","批量获取用户基本信息"),
    USERS_ATTRACT_LIST(9014,"https://api.weixin.qq.com/cgi-bin/user/get","GET","获取关注列表"),
    TEMPLATE_SET_INDUSTRY(9015,"https://api.weixin.qq.com/cgi-bin/template/api_set_industry","POST","设置模版所属行业"),
    TEMPLATE_GET_INDUSTRY_INFO(9016,"https://api.weixin.qq.com/cgi-bin/template/get_industry","GET","获取所属行业信息"),
    TEMPLATE_GET_ALL(9017,"https://api.weixin.qq.com/cgi-bin/template/get_all_private_template","GET","获取所有模版信息"),
    TEMPLATE_SEND(9018,"https://api.weixin.qq.com/cgi-bin/message/template/send","POST","发送模版消息"),
    PREVIEW(9019,"https://api.weixin.qq.com/cgi-bin/message/mass/preview","POST","根据微信号预览消息"),
    MESSAGE_SEND_BY_TAG(9020,"https://api.weixin.qq.com/cgi-bin/message/mass/sendall","POST","根据标签群发"),
    MENU_CREATE(9021,"https://api.weixin.qq.com/cgi-bin/menu/create","POST","自定义菜单"),
    MENU_GET(9022,"https://api.weixin.qq.com/cgi-bin/menu/get","GET","获取自定义菜单"),
    MENU_DELETE(9023,"https://api.weixin.qq.com/cgi-bin/menu/delete","GET","删除自定义菜单"),
    ACCESS_TOKEN(9024,"https://api.weixin.qq.com/cgi-bin/token","GET","获取accessToken"),
    SEND_MESSAGE_TO_ONE(9025,"https://api.weixin.qq.com/cgi-bin/message/custom/send","POST","客服发送消息接口"),
    MEDIA_LIST_GET(9026,"https://api.weixin.qq.com/cgi-bin/material/batchget_material","POST","获取素材列表");
    private Integer type;
    private String value;
    private String methodType;
    private String desc;

    WxApiUrlEnum(Integer type, String value, String methodType, String desc) {
        this.type = type;
        this.value = value;
        this.methodType = methodType;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
