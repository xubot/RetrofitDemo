package com.example.administrator.retrofitdemo.Utils;

import com.example.administrator.retrofitdemo.Bean.NameBean;
import com.example.administrator.retrofitdemo.Bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/5/10.
 */

public interface RequestServes {
    @GET("/api/cook/classify")
    Call<String> getClassify();
    @GET("/api/cook/name")
    Call<NameBean> getName(@Query("name")String name);
    @GET("/users/{user}")
    Call<UserBean> getUser(@Path("user")String user);
}
