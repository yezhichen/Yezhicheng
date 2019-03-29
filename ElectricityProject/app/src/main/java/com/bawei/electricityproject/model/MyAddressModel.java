package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.AddressBean;
import com.bawei.electricityproject.contract.MyAddressContract;
import com.bawei.electricityproject.utils.RetrofitUtils2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 叶至成 on 2019/3/29.
 */
public class MyAddressModel implements MyAddressContract.MyAddressModel {
    @Override
    public void response(String userId, String sessionId, final MyAddressCallBack addressCallBack) {
        ApiService apiService = RetrofitUtils2.getInstance().setCreate(ApiService.class);
        Observable<AddressBean> getaddress = apiService.getaddress(userId, sessionId);
        getaddress.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<AddressBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddressBean value) {
                        List<AddressBean.ResultBean> result = value.getResult();
                        addressCallBack.CallBack(result);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
