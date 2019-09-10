package com.jone.pro.common.enums.wechat;





import com.jone.pro.common.vo.MenuType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/10/26 下午3:26
 * @Description:
 */
public enum MenuTypeEnum {
    CLICK(1,"click","点击"),
    VIEW(2,"view","网页URL"),
    SCANCODE_PUSH(3,"scancode_push","扫一扫"),
    SCANCODE_WAITMSG(4,"scancode_waitmsg","扫一扫提示等待"),
    PIC_SYSPHOTO(5,"pic_sysphoto","拍照"),
    PIC_PHOTO_OR_ALBUM(6,"pic_photo_or_album","拍照或相册"),
    PIC_WEIXIN(7,"pic_weixin","微信相册发图器"),
    LOCATION(8,"location_select","位置"),
    MEDIA_ID(9,"media_id","永久素材发送"),
    VIEW_LIMITED(10,"view_limited","图文永久素材"),
    ;
    private Integer no;
    private String value;
    private String name;

    MenuTypeEnum(Integer no, String value, String name) {
        this.no = no;
        this.value = value;
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static List<MenuType> getAllMenuType(){
        List<MenuType> menuTypes = new ArrayList<>();
        for (MenuTypeEnum e:MenuTypeEnum.values()){
            MenuType menuType = new MenuType();
            menuType.setMenuName(e.getName());
            menuType.setMenuValue(e.getValue());
            menuTypes.add(menuType);
        }
        return menuTypes;
    }

    private static MenuTypeEnum getByValue(String value){
        for (MenuTypeEnum e:MenuTypeEnum.values()){
            if(e.getValue().equals(value)){
                return e;
            }
        }
        return null;
    }
}
