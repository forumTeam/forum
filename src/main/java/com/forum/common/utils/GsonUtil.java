/**
 * 文件名：GsonUtil.java
 * 创建日期： 2016年7月25日
 * 作者： lizhangxiong
 * 版权所有(C) 2016-2017 深圳市百立特信息技术有限公司 保留所有权利.
 */
package com.forum.common.utils;


import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.*;

/**
 * 功能描述： 谷歌gson组件操作封装
 *
 * @author lizhangxiong 2016年7月25日
 */
public class GsonUtil {
    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = /* new Gson(); */ new GsonBuilder().registerTypeAdapter(new TypeToken<Date>() {
            }.getType(), (JsonDeserializer<Date>) (arg0, arg1, arg2) -> {
                try {
                    String jsonStr = arg0.getAsString();
                    if (arg0 instanceof JsonPrimitive) {
                        if (((JsonPrimitive) arg0).isNumber()) {
                            return new Date(Long.parseLong(jsonStr));
                        }
                    }
                    return DateUtil.stringToDate(jsonStr);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;

            }).setDateFormat(DateUtil.YEAR_MONTH_DAY_HH_MM_SS)
                    .registerTypeAdapter(new TypeToken<TreeMap<String, Object>>() {
                    }.getType(), (JsonDeserializer<TreeMap<String, Object>>) (arg0, arg1, arg2) -> {
                        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
                        JsonObject jsonObject = arg0.getAsJsonObject();
                        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                        for (Map.Entry<String, JsonElement> entry : entrySet) {
                            treeMap.put(entry.getKey(), entry.getValue());
                        }
                        return treeMap;
                    }).create();

        }

    }

    private GsonUtil() {
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String json = null;
        if (object == null) {
            return json;
        }
        if (gson != null) {
            json = gson.toJson(object);
        }
        return json;
    }

    /**
     * 转成bean
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T toBean(String json, Class<T> cls) {
        T t = null;
        if (StringUtil.isEmpty(json)) {
            return t;
        }
        if (gson != null) {
            t = gson.fromJson(json, cls);
        }
        return t;
    }

    /**
     * 转成bean
     * @param json
     * @param typeOfT
     * @return
     */
    public static <T> T toBean(String json, Type typeOfT) {
        T t = null;
        if (StringUtil.isEmpty(json) || typeOfT == null) {
            return t;
        }
        if (gson != null) {
            t = gson.fromJson(json, typeOfT);
        }
        return t;
    }

    /**
     * 转成list
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> cls) {
        List<T> list = null;
        if (StringUtil.isEmpty(json) || cls == null) {
            return list;
        }
        if (gson != null) {
            list = gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list中有map的
     *
     * @param json
     * @return
     */
    public static <T> List<Map<String, T>> toListMaps(String json) {
        List<Map<String, T>> list = null;
        if (StringUtil.isEmpty(json)) {
            return list;
        }
        if (gson != null) {
            list = gson.fromJson(json, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param json
     * @return
     */
    public static <T> Map<String, T> toMaps(String json) {
        Map<String, T> map = null;
        if (StringUtil.isEmpty(json)) {
            return map;
        }
        if (gson != null) {
            map = gson.fromJson(json, new TypeToken<TreeMap<String, Object>>() {
            }.getType());
        }
        return map;
    }
}

