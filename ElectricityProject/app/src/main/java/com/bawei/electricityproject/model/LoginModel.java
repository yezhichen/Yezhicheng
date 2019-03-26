package com.bawei.electricityproject.model;

import android.util.Log;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.LoginBean;
import com.bawei.electricityproject.contract.LoginContract;
import com.bawei.electricityproject.utils.RetrofitUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class LoginModel implements LoginContract.LoginModel {


    @Override
    public void response(String login_phone, String login_pwd, final callBack back) {
        Retrofit retrofit = RetrofitUtils.getInstance().doGet(Api.login);
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("phone", login_phone);
        stringStringHashMap.put("pwd", login_pwd);
        Call<LoginBean> login = apiService.getLogin(stringStringHashMap);
        login.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                String status = response.body().getStatus();
                String sessionId = response.body().getResult().getSessionId();
                int userId = response.body().getResult().getUserId();
                Log.i("ssssss", userId+"onResponse:短 "+sessionId);
                back.back(status,sessionId,userId);
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }
}
