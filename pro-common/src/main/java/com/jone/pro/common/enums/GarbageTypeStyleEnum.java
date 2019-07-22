package com.jone.pro.common.enums;

import lombok.Data;

import java.util.Objects;

/**
 * @author yanjing
 * @date 2019/7/19 9:00
 */
public enum  GarbageTypeStyleEnum implements BaseEnum {
    HOT_STYLE("hotStyle","干垃圾",1149885783951450114L),
    CIRCLES_TYLE("circleStyle","可回收垃圾",1149885784190525442L),
    WEAT_STYLE("weatStyle","湿垃圾",1149885784354103297L),
    HARMFUL_STYLE("harmfulStyle","有害垃圾",1149886649873944578L),
    BIG_STYLE("bigStyle","大件垃圾",1149886650196905986L),
    BUILD_STYLE("buildStyle","建筑垃圾",1149895870229204993L),
    NOT_DAILY_STYLE("notDailyStyle","不属于日常生活垃圾",1149895870539583489L),
    ;

    private String code;
    private String desc;
    private Long id;

    GarbageTypeStyleEnum(String code, String desc, Long id) {
        this.code = code;
        this.desc = desc;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public GarbageTypeStyleEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public GarbageTypeStyleEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Long getId() {
        return id;
    }

    public GarbageTypeStyleEnum setId(Long id) {
        this.id = id;
        return this;
    }

    public static GarbageTypeStyleEnum getInstance(Long typeId){
        GarbageTypeStyleEnum garbageTypeStyleEnum = null;
        for (GarbageTypeStyleEnum item:GarbageTypeStyleEnum.values()){
            if (Objects.equals(item.getId(),typeId)){
                garbageTypeStyleEnum = item;
                break;
            }
        }
        return garbageTypeStyleEnum;
    }
}
