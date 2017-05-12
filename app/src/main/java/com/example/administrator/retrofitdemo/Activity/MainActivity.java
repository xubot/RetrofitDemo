package com.example.administrator.retrofitdemo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.administrator.retrofitdemo.Bean.NameBean;
import com.example.administrator.retrofitdemo.Bean.UserBean;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.Utils.EncapsulationUrl;
import com.example.administrator.retrofitdemo.Utils.HttpLoggingInterceptor;
import com.example.administrator.retrofitdemo.Utils.RequestServes;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        client = HttpLoggingInterceptor.httpLoggingInterceptor();
        //无参的请求
        setClassify();
        //有参的请求，后面已&连接
        serName();
        //有参的请求，后面已/连接
        serUser();
    }
    //有参的请求，后面已/连接
    private void serUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EncapsulationUrl.ADDRESS_PATH)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //得到动态代理
        RequestServes requestServes = retrofit.create(RequestServes.class);
        Call<UserBean> call = requestServes.getUser("aaa");
        call.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                UserBean body = response.body();
                String avatar_url = body.getAvatar_url();
                Log.d("zzz",avatar_url);
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });
    }
    //有参的请求，后面已&连接
    private void serName() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EncapsulationUrl.ADDRESS_URI)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //得到动态代理
        RequestServes requestServes = retrofit.create(RequestServes.class);
        Call<NameBean> call = requestServes.getName("地三鲜");
        call.enqueue(new Callback<NameBean>() {
            @Override
            public void onResponse(Call<NameBean> call, Response<NameBean> response) {
                List<NameBean.TngouBean> tngou = response.body().getTngou();
                for(NameBean.TngouBean tb:tngou){
                    String name = tb.getName();
                    Log.d("zzz1",name);
                }
            }

            @Override
            public void onFailure(Call<NameBean> call, Throwable t) {

            }
        });
    }
    //无参的请求
    private void setClassify() {
        Retrofit builder = new Retrofit.Builder().baseUrl(EncapsulationUrl.ADDRESS_URL)
                .client(client)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestServes requestServes = builder.create(RequestServes.class);
        Call<String> call = requestServes.getClassify();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Log.d("zzz", response.body() + "");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
