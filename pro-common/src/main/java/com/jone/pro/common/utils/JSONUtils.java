package com.jone.pro.common.utils;


import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JSONUtils() {
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static <T> T json2pojoAndOffUnknownField(String jsonStr, Class<T> clazz) throws Exception {
        if (StringUtils.isNotEmpty(jsonStr)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonStr, clazz);
        } else {
            return null;
        }
    }

    public static String obj2json(Object obj) throws Exception {
        return obj != null ? objectMapper.writeValueAsString(obj) : null;
    }

    public static String obj2jsonNoException(Object obj) {
        if (obj != null) {
            try {
                return objectMapper.writeValueAsString(obj);
            } catch (JsonProcessingException var2) {
                var2.printStackTrace();
            }
        }

        return null;
    }

    public static <T> T json2pojo(String jsonStr, Class<T> clazz) throws Exception {
        return StringUtils.isNotEmpty(jsonStr) ? objectMapper.readValue(jsonStr, clazz) : null;
    }

    public static <T> T json2pojoNoException(String jsonStr, Class<T> clazz) {
        try {
            return StringUtils.isNotEmpty(jsonStr) ? objectMapper.readValue(jsonStr, clazz) : null;
        } catch (IOException var3) {
            return null;
        }
    }

    public static <T> Map<String, Object> json2map(String jsonStr) throws Exception {
        return StringUtils.isNotEmpty(jsonStr) ? (Map)objectMapper.readValue(jsonStr, Map.class) : null;
    }

    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) throws Exception {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        } else {
            Map<String, Map<String, Object>> map = (Map)objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {
            });
            Map<String, T> result = new HashMap();
            Iterator var4 = map.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, Map<String, Object>> entry = (Entry)var4.next();
                result.put(entry.getKey(), map2pojo((Map<String, Object>) entry.getValue(), clazz));
            }

            return result;
        }
    }

    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) throws Exception {
        if (StringUtils.isEmpty(jsonArrayStr)) {
            return null;
        } else {
            objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            List<Map<String, Object>> list = (List)objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>() {
            });
            List<T> result = new ArrayList();
            Iterator var4 = list.iterator();

            while(var4.hasNext()) {
                Map<String, Object> map = (Map)var4.next();
                result.add(map2pojo(map, clazz));
            }

            return result;
        }
    }

    public static <T> List<T> json2listNoException(String jsonArrayStr, Class<T> clazz) {
        ArrayList result = new ArrayList();

        try {
            if (StringUtils.isEmpty(jsonArrayStr)) {
                return null;
            }

            objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            List<Map<String, Object>> list = null;
            list = (List)objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>() {
            });
            Iterator var4 = list.iterator();

            while(var4.hasNext()) {
                Map<String, Object> map = (Map)var4.next();
                result.add(map2pojo(map, clazz));
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }

    public static <T> T map2pojo(Map<String, Object> map, Class<T> clazz) {
        return map == null ? null : objectMapper.convertValue(map, clazz);
    }
}
