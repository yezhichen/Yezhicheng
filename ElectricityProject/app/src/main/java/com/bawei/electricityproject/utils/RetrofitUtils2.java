package com.bawei.electricityproject.utils;

import android.util.Log;

import com.bawei.electricityproject.api.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 叶至成 on 2019/3/23.
 */
public class RetrofitUtils2 {
    private static RetrofitUtils2 retrofitUtils;

    private RetrofitUtils2() {
    }

    public static RetrofitUtils2 getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils2();
                }
            }
        }
        return retrofitUtils;
    }

    private static OkHttpClient okHttpClient;

    private static synchronized OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lj", "log: " + message);
            }
        });
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)

                .build();
        return okHttpClient;
    }

    private static Retrofit retrofit;

    private static synchronized Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.bw)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
        return retrofit;
    }
    public <T> T setCreate(Class<T> apiService) {

        Retrofit retrofit = getRetrofit();

        return retrofit.create(apiService);

    }

}
