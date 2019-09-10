package com.jone.pro.common.utils;

import com.thoughtworks.xstream.XStream;

/**
 * @Author: yanjing
 * @Date: 2018/10/25 下午5:02
 * @Description:
 */
public class XmlBeanUtils<T>{


    public static <T> T getBeanByXml(String xml, Class<T>  tClass){
        XStream xStream = new XStream();
        xStream.alias("xml",tClass);

        T o = (T) xStream.fromXML(xml);
        return o;
    }

    public static <T> T  getXmlByBean(Object o,Class<T> tClass){
        XStream xStream = new XStream();
        xStream.alias("xml",tClass);
        T s = (T) xStream.toXML(o);
        return s;
    }

}
