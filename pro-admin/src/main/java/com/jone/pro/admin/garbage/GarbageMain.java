package com.jone.pro.admin.garbage;

import com.google.common.collect.Lists;
import com.jone.pro.common.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanjing
 * @date 2019/7/11 10:57
 */
public class GarbageMain {
    public static void main(String[] args) {
        String url = "https://www.metalgearjoe.cn/mn/search";
        Map<String, String> params = new HashMap<>();
        params.put("search","垃圾");
        String s = HttpClientUtils.doGet(url, params);
        String s2 = s.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\n\t", "").replaceAll("]","");
        int i = s2.indexOf("<divclass");
        String substring = s2.substring(i + 1);
        String[] split = substring.split("</div>");
        List<String> garbages = Lists.newArrayList(split);

        List<GarBage> garbageAnda = Lists.newArrayList();
        garbages.stream()
                .filter(item->item.contains("divclass"))
                .collect(Collectors.toList())
                .stream().forEach(item2->{
            int index = item2.indexOf(">");
            String garbageAndCate = item2.substring(index + 1);
            String[] nameAndCate = garbageAndCate.split("&nbsp;\\[");
            GarBage garBage = new GarBage();
            garBage.setGarbageName(nameAndCate[0]);
            garBage.setCategory(nameAndCate[1]);
            garbageAnda.add(garBage);
        });
        System.out.println(garbageAnda);
    }
}
