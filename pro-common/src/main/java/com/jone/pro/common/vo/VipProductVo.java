package com.jone.pro.common.vo;


/**
 * @author xiaochong
 * @create 2018/8/16 下午9:49
 * @description
 */
public class VipProductVo {

    private Integer key;

    private String name;

    private String price;

    private String originalPrice;

    private String rebate;

    private Boolean isRecommends;

    private String color;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate;
    }

    public Boolean getIsRecommends() {
        return isRecommends;
    }

    public void setIsRecommends(Boolean recommends) {
        isRecommends = recommends;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
