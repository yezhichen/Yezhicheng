package com.bawei.electricityproject.api;

import com.bawei.electricityproject.bean.BannerBean;
import com.bawei.electricityproject.bean.DetailedBean;
import com.bawei.electricityproject.bean.KeyWordBean;
import com.bawei.electricityproject.bean.LoginBean;
import com.bawei.electricityproject.bean.RegisterBean;
import com.bawei.electricityproject.bean.ShopBean;
import com.bawei.electricityproject.bean.ShowBean;
import com.bawei.electricityproject.bean.SuccessBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public interface ApiService {
    //登录
    @POST("user/v1/login")
    Call<LoginBean> getLogin(@QueryMap Map<String, String> map);

    //注册
    @POST("user/v1/register")
    Call<RegisterBean> getRegister(@QueryMap Map<String, String> map);

    //轮播
    @GET("commodity/v1/bannerShow")
    Call<BannerBean> getBanner();

    //首页
    @GET("commodity/v1/commodityList")
    Call<ShowBean> getShow();

    //详情
    @GET("v1/findCommodityDetailsById")
    Call<DetailedBean> getDetailed(@Query("commodityId") String id, @Query("userId") String userId, @Query("sessionId") String sessionId);

    //搜索
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<KeyWordBean> getSearch(@Query("keyword") String keyword, @Query("page") int page, @Query("count") String count);

    //查询购物车http://mobile.bwstudent.com/small/order/verify/v1/findShoppingCart
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<ShopBean> getShop(@Header("userId") String userId, @Header("sessionId") String sessionId);

    //添加购物车 http://mobile.bwstudent.com/small/order/verify/v1/syncShoppingCart
    @PUT("small/order/verify/v1/syncShoppingCart")
    Observable<SuccessBean> getSuccess(@Header("userId") String userId, @Header("sessionId") String sessionId, @QueryMap Map<String, String> data);
}
