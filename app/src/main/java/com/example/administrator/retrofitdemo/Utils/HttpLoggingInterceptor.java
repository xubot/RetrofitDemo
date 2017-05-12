package com.example.administrator.retrofitdemo.Utils;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/5/11.
 */

public class HttpLoggingInterceptor {
    public static OkHttpClient httpLoggingInterceptor() {
        okhttp3.logging.HttpLoggingInterceptor interceptor = new okhttp3.logging.HttpLoggingInterceptor(new okhttp3.logging.HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //Log.d("zzz2", "massage" + message);
            }
        });
        interceptor.setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }
}
