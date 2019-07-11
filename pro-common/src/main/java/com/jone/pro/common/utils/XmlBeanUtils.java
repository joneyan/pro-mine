/*
package com.jone.pro.common.utils;

import com.thoughtworks.xstream.XStream;

*/
/**
 * @Author: yanjing
 * @Date: 2018/10/25 下午5:02
 * @Description:
 *//*

public class XmlBeanUtils {


    public static Object getBeanByXml(String xml,String packge){
        XStream xStream = new XStream();
        dealXstream(xStream,packge);

        Object o = xStream.fromXML(xml);
        return o;
    }

    public static String getXmlByBean(Object o,String packge){
        XStream xStream = new XStream();
        dealXstream(xStream,packge);
        String s = xStream.toXML(o);
        return s;
    }

    public static void dealXstream(XStream xStream,String packge){
        Class aClass =null;
        try {
            aClass = Class.forName(packge);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        xStream.alias("xml",aClass);
    }
}
*/
