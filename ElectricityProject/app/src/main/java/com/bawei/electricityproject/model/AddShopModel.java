package com.bawei.electricityproject.model;

import android.util.Log;

import com.bawei.electricityproject.api.Api;
import com.bawei.electricityproject.contract.AddShopContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

/**
 * Created by 叶至成 on 2019/3/27.
 */
public class AddShopModel implements AddShopContract.AddShopModel {
    @Override
    public void response(String userId, String sessionId, String data, final AddShopCallBack callBack) {
      //  Log.i("tag","點擊了"+data+userId+sessionId);
       /* ApiService apiService = RetrofitUtils2.getInstance().setCreate(ApiService.class);
        Observable<SuccessBean> success = apiService.getSuccess(userId,sessionId,data);
        success.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SuccessBean>() {
                    @Override
                    public void accept(SuccessBean successBean) throws Exception {
                        String message = successBean.getMessage();
                        Log.i("aaa",message);

                      //  callBack.CallBack(message);
                    }
                });*/

        //使用ok Go
        OkGo.<String>put(Api.gogo)
                .headers("userId",userId)
                .headers("sessionId",sessionId)
                .params("data",data)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        String s = response.body().toString();
                       Log.i("aa",s);
                    }
                });

    }
}
