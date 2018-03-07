package com.yxkj.yqcp.util;

public class AESUtil {
    static String key = "8zQSb7wwzUkWIVQax5kaZM4I";

    public static String aesEncrypt(String content)throws Exception{
        String jsonStr = TransferAesEncrypt.aesEncrypt(content,key,"utf-8");
        return jsonStr;
    }
}
