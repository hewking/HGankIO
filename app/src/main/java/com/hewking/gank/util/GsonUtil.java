package com.hewking.gank.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 18:17
 * @description: ${description}
 **/
public class GsonUtil {

    public static <T> String toJson(T data){
        return new Gson().toJson(data);
    }

    public static <T> T fromJson(String json,Class<T> clazz){
        return new Gson().fromJson(json,clazz);
    }

    public static <T> T fromJson(String json,Type type){
//        Type type  = new TypeToken<List<T>>(){}.getType();
        return new Gson().fromJson(json,type);
    }

}
