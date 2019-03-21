package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.BannerBean;
import com.bawei.electricityproject.contract.BannerContract;
import com.bawei.electricityproject.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class BannerModel implements BannerContract.BannerModel {
    @Override
    public void response(final BannerCallBack callBack) {
        Retrofit retrofit = RetrofitUtils.getInstance().doGet(Api.banner);
        ApiService apiService = retrofit.create(ApiService.class);
        Call<BannerBean> banner = apiService.getBanner();
        banner.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                List<BannerBean.ResultBean> result = response.body().getResult();
                callBack.CallBack(result);
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {

            }
        });
    }
}
