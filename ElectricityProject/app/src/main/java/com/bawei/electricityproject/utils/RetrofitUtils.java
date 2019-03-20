package com.bawei.electricityproject.utils;

import android.util.Log;

import com.bawei.electricityproject.api.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils = null;

    private RetrofitUtils() {
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    private static OkHttpClient okHttpClient;

    public static synchronized OkHttpClient getOkHttpClient(){
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("xxx",message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

        }
        return okHttpClient;
    }
    public static Retrofit doGet(String url) {
        //网络请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit;
    }
    public <T> T getApiService(String url,Class<T>service){
        Retrofit retrofit = doGet(url);
        T t = retrofit.create(service);
        return t;
    }

}
