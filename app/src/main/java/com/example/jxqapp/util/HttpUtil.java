package com.example.jxqapp.util;

import java.io.File;
import java.util.*;
import okhttp3.*;

/**
 * Created by xgh007 on 2020/2/4.
 * 这个类是专门进行发送Http请求的操作的，在本程序的任何地方都能调用这个类的方法来向后台发送请求
 * 这个类中定义了2个方法，分别用于发送GET请求与POST请求
 * 如果需要传递参数，要注意的的是：GET请求的参数直接是写在url上的，而POST请求的参数需要填在map中
 * 这个类只负责发送请求，对响应或错误的具体处理，我们应该定义在okhttp3.Callback中，我们需要new一
 * 个okhttp3.Callback对象，然后重写其的回调函数即可：“onResponse”和“onFailure” v0.1
 * ------------------------------------
 * 2020/2/11
 * 增加了一个向后台上传文件的方法 v0.2
 */
public class HttpUtil {

    /*// 发送GET请求
    public static void sendGetRequest(String url, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient(); // 创建一个client
        Request request = new Request.Builder().url(url).build(); // 组装一个Request对象
        client.newCall(request).enqueue(callback); // 发送请求
    }*/

    // 发送POST请求
    public static void sendPostRequest(final String url, final Map<String, Object> map, final okhttp3.Callback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient(); // 创建一个client
                // POST请求的参数需要放在一个RequestBody对象中，它由FormBody.Builder建造者类来建造（建造者模式）
                FormBody.Builder builder = new FormBody.Builder();
                if(map != null){
                    // 不能直接把map转为RequestBody，必须遍历map的key，并逐一地往builder中添加对应的value
                    Set<String> keys = map.keySet();
                    for(String key : keys){ // 注意：RequestBody的参数只能是字符串类型的
                        String value = map.get(key).toString();
                        builder.add(key, value);
                    }
                }
                RequestBody requestBody = builder.build(); // 最后利用builder来生成一个RequestBody实例
                // 组装一个Request对象（这次有额外传入RequestBody）
                Request request = new Request.Builder().url(url).post(requestBody).build();
                client.newCall(request).enqueue(callback); // 发送请求
            }
        }).start();

    }
    // 处理文件上传 -- 每次发送一个文件
    public static void sendUploadFileRequest(String url, File file, Map<String, Object> map, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient(); // 创建一个client
        MediaType mediaType = MediaType.parse("application/octet-stream"); // 类型为八位字节流
        RequestBody requestBody = RequestBody.create(mediaType, file); //把文件与类型放入请求体
        MultipartBody.Builder builder = new MultipartBody.Builder(); // MultipartBody的建造者
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("file", file.getName(), requestBody); // 设置参数名，后台接收一个“file”的文件参数
        Set<String> keys = map.keySet();
        for(String key : keys) { // 这里还可以接收一些String类型的参数
            String value = map.get(key).toString();
            builder.addFormDataPart(key, value);
        }
        MultipartBody multipartBody = builder.build(); // 建造一个请求体
        Request request = new Request.Builder()
                .url(url) // 指定url
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback); // 让callback来处理回调结果
    }
}

