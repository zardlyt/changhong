package com.changhong.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wb-zhaofugui on 2016/12/27.
 */
public class JsonUtils {
    /**
     * 将Json字符串转换为Map
     * @param jsonString
     * @return
     */
    public static Map<String, Object> toMap(String jsonString){
        Map<String, Object> map=new HashMap<String, Object>();
        if(null == jsonString){
            return map;
        }
        JSONObject json=JSONObject.fromObject(jsonString);
        Iterator<?> keys=json.keys();
        while(keys.hasNext()){
            String key=(String) keys.next();
            String value=json.get(key).toString();
            if(value.startsWith("{")&&value.endsWith("}")){
                map.put(key, toMap(value));
            }else{
                map.put(key, value);
            }
        }
        return map;
    }


    /**
     * 根据Class将json字符串转换成指定泛型的List集合
     * @param jsonString
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> toList(String jsonString, Class<Map> clazz){
        if(null == jsonString){
            return null;
        }
        return (List<T>) JSONArray.toCollection(JSONArray.fromObject(jsonString),clazz);
    }


    /**
     * 将JSON格式的String转为JSON
     * @param jsonString
     * @return
     */
    public static JSONObject stringToJson(String jsonString){
        return JSONObject.fromObject(jsonString);
    }

    /**
     * 把Object转换成Json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        if(null == object){
            return "{}";
        }
        if(object instanceof List<?> || object instanceof Object[]){
            JSONArray jsonArray = JSONArray.fromObject(object);
            return null == jsonArray ? null : jsonArray.toString();
        }
        JSONObject jsonObject = JSONObject.fromObject(object);
        return null == jsonObject ? null  : jsonObject.toString();
    }

    /**
     * 根据参数配置把Object转换成Json字符串
     * @param object
     * @param jsonConfig
     * @return
     */
    public static String toJsonString(Object object,JsonConfig jsonConfig){
        if(null == object){
            return "{}";
        }
        if(object instanceof List<?> || object instanceof Object[]){
            JSONArray jsonArray = JSONArray.fromObject(object, jsonConfig);
            return null == jsonArray ? null : jsonArray.toString();
        }
        JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
        return null == jsonObject ? null : jsonObject.toString();
    }

    /**
     * 把JsonObject转换成Object
     * @param jsonObject
     * @return
     */
    public static Object toBean(JSONObject jsonObject){
        return JSONObject.toBean(jsonObject);
    }

    /**
     * 把Json字符串转换成Object
     * @param jsonString
     * @return
     */
    public static Object toBean(String jsonString){
        if(null == jsonString){
            return null;
        }
        if(jsonString.startsWith("[")){
            return JSONArray.toCollection(JSONArray.fromObject(jsonString));
        }
        return JSONObject.toBean(JSONObject.fromObject(jsonString));
    }

    /**
     * 根据Class把JsonObject转换成指定类型
     * @param <T>
     * @param jsonObject
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBean(JSONObject jsonObject,Class<T> clazz){
        return (T) JSONObject.toBean(jsonObject,clazz);
    }

    /**
     * 根据Class把Json字符串转换成指定类型,如果class为Map,直接调用转换成Map的方法
     * @param jsonString
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBean(String jsonString,Class<T> clazz){
        if(null == jsonString){
            return null;
        }
        if(jsonString.startsWith("[")){
            return (T) JSONArray.toCollection(JSONArray.fromObject(jsonString),clazz);
        }
        if(clazz.equals(Map.class) || clazz.equals(HashMap.class)){
            return (T) toMap(jsonString);
        }
        else{
            return (T) JSONObject.toBean(JSONObject.fromObject(jsonString),clazz);
        }
    }

    /**
     * 根据Class把Json字符串转换成指定类型,针对复合类型，使用暗示将复合类型解析
     * @param jsonString
     * @param clazz
     * @param classMap
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBean(String jsonString,Class<T> clazz,Map<String, Class<?>> classMap){
        if(null == jsonString){
            return null;
        }
        JSONObject jsonObj = JSONObject.fromObject(jsonString);
        return (T) JSONObject.toBean(jsonObj,clazz,classMap);
    }

    /**
     * 根据Class将json字符串转换成指定类型的数组
     * @param jsonString
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArrayBean(String jsonString, Class<T> clazz){
        if(null == jsonString){
            return null;
        }
        return (T[]) JSONArray.toArray(JSONArray.fromObject(jsonString),clazz);
    }



    /**
     * 数据提取
     * @param json
     * @param sign 提取key值
     * @return
     */
    public static String dataToString(JSONObject json,String sign){
        return json.has(sign)?json.getString(sign):null;
    }
    /**
     * 数据提取,带替补
     * @param json
     * @param sign1 主发key值
     * @param sign2 替补key值
     * @return
     */
    public static String dataToString(JSONObject json,String sign1,String sign2){
        return json.has(sign1)?json.getString(sign1):json.has(sign2)?json.getString(sign2):null;
    }
    /**
     * 数据提取，带替补
     * @param json
     * @param sign1 主发key值
     * @param sign2 二队key值
     * @param sign3 板凳key值
     * @return
     */
    public static String dataToString(JSONObject json,String sign1,String sign2,String sign3){
        return json.has(sign1)?json.getString(sign1):json.has(sign2)?json.getString(sign2):json.has(sign3)?json.getString(sign3):null;
    }
}
