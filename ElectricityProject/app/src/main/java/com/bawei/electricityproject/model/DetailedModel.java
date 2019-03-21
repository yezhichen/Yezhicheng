package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.DetailedBean;
import com.bawei.electricityproject.contract.DetailedContract;
import com.bawei.electricityproject.utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class DetailedModel implements DetailedContract.DetailedModel {
    @Override
    public void response(String id, DetailedCallBack callBack) {
        Retrofit retrofit = RetrofitUtils.getInstance().doGet(Api.detailed);
        ApiService apiService = retrofit.create(ApiService.class);
        Call<DetailedBean> detailed = apiService.getDetailed(id);

    }
}
