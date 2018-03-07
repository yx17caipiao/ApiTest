package com.yxkj.yqcp.util;

import com.google.gson.Gson;

public class JsonUtil {
    static Gson mGson;
    public static <T> T parseJson(String json,Class<T> tClass){
        if(mGson==null){
            mGson = new Gson();
        }
        if(json.equals("")||json.equals(null)){
            return null;
        }
        return mGson.fromJson(json,tClass);
    }
}
