package com.jone.pro.common.utils;

/**
 * @Author: yanjing
 * @Date: 2019/5/22 下午9:18
 * @Description:
 */
public class PathUtils {

    public static String getLocalPath(){
        String pathGet = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int firstIndex = pathGet.indexOf("/");
        String path1 = pathGet.substring(firstIndex);
        Integer lastIndex = path1.lastIndexOf("/");
        String subPath1 = path1.substring(0, lastIndex);
        lastIndex = subPath1.lastIndexOf("/");
        String subPath2 = subPath1.substring(0, lastIndex);
        lastIndex = subPath2.lastIndexOf("/");
        String subPath3 = subPath2.substring(0, lastIndex);
        lastIndex = subPath3.lastIndexOf("/");
        String path = subPath3.substring(0, lastIndex);
        return path;
    }
}
