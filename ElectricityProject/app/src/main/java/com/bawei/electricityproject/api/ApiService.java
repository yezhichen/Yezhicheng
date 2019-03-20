package com.bawei.electricityproject.api;

import com.bawei.electricityproject.bean.LoginBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public interface ApiService {
    @POST("user/v1/login")
    Call<LoginBean> getLogin(@QueryMap Map<String,String> map);
}
