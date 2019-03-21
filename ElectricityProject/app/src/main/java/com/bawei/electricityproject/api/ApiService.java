package com.bawei.electricityproject.api;

import com.bawei.electricityproject.bean.BannerBean;
import com.bawei.electricityproject.bean.DetailedBean;
import com.bawei.electricityproject.bean.LoginBean;
import com.bawei.electricityproject.bean.RegisterBean;
import com.bawei.electricityproject.bean.ShowBean;

import java.util.Map;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public interface ApiService {
    //登录
    @POST("user/v1/login")
    Call<LoginBean> getLogin(@QueryMap Map<String,String> map);
    //注册
    @POST("user/v1/register")
    Call<RegisterBean> getRegister(@QueryMap Map<String,String> map);
    //轮播
    @GET("commodity/v1/bannerShow")
    Call<BannerBean> getBanner();
    //首页
    @GET("commodity/v1/commodityList")
    Call<ShowBean> getShow();
    //详情
    @GET("v1/findCommodityDetailsById")
    Call<DetailedBean> getDetailed(@Query("commodityId") String id);
}
