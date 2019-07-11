package com.jone.pro.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/10/25 下午5:06
 * @Description:
 */
public class ReflectUtils {

    /**
     * 获取实体的属性
     *
     * @param clas
     * @return
     */
    public static List<Field> getFiles(Class clas ){
        Field[] declaredFields = clas.getDeclaredFields();
        List<Field> fields = new ArrayList<>();
        for (Field field:declaredFields){
            fields.add(field);
        }
        return fields;

    }

    /**
     * 获取实体的属性名字
     *
     * @param fields
     * @return
     */
    public static List<String> getFiledsName(List<Field> fields){
        List<String> fieldNames = new ArrayList();
        for (Field field:fields){
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
