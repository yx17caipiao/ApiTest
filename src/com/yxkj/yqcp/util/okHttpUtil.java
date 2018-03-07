package com.yxkj.yqcp.util;

import okhttp3.*;

import java.io.IOException;

public class okHttpUtil {
    static OkHttpClient okClient = new OkHttpClient();
    static Request.Builder builder = new Request.Builder();



    /**
     * 发起get请求
     *
     * @param url
     * @return
     */
    public static String httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送httppost请求
     *
     * @param url
     * @param data  提交的参数为key=value&key1=value1的形式
     * @return
     */
    public static String httpPost(String url, String data) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html;charset=utf-8"), data);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }





    public static String HttpGetRequest(String url){
        Request request = builder.get().url(url).build();
        Call call = okClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        return null;
    }

    public static String HttpPostRequest(String url,String data) throws Exception{
        String str = "";
        String jsonStr = AESUtil.aesEncrypt(data);
        RequestBody requestBody = new FormBody.Builder().add("request",jsonStr).build();
        Request requestPost = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        okClient.newCall(requestPost).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.getMessage();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
            }
        });

        return null;
    }


}
