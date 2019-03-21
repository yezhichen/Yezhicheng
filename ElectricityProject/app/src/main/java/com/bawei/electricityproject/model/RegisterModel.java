package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.RegisterBean;
import com.bawei.electricityproject.contract.RegisterContract;
import com.bawei.electricityproject.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void response(String register_phone, String register_pwd, final RegisterCallback callback) {
        Retrofit retrofit = RetrofitUtils.getInstance().doGet(Api.regiter);
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> registerHashMap  = new HashMap<>();
        registerHashMap.put("phone",register_phone);
        registerHashMap.put("pwd",register_pwd);
        Call<RegisterBean> register = apiService.getRegister(registerHashMap);
        register.enqueue(new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                String status = response.body().getStatus();
                callback.back(status);
            }

            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {

            }
        });
    }
}
