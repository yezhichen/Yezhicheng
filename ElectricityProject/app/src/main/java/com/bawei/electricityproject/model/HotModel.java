package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.ShowBean;
import com.bawei.electricityproject.contract.HotContract;
import com.bawei.electricityproject.utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class HotModel implements HotContract.BannerModel {
    @Override
    public void response(final HotCallBack callBack) {
        Retrofit retrofit = RetrofitUtils.getInstance().doGet(Api.show);
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ShowBean> show = apiService.getShow();
        show.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                ShowBean.ResultBean result = response.body().getResult();
                callBack.CallBack(result);
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

            }
        });
    }
}
