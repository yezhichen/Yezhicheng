package com.bawei.electricityproject.model;

import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.bean.ShopBean;
import com.bawei.electricityproject.contract.ShopContract;
import com.bawei.electricityproject.contract.ShopTowContract;
import com.bawei.electricityproject.utils.RetrofitUtils2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public class ShopTowModel implements ShopTowContract.ShopTowModel {
    @Override
    public void response(String userId, String sessionId, final ShopContract.ShopModel.ShopCallBack shopCallBack) {
        ApiService apiService = RetrofitUtils2.getInstance().setCreate(ApiService.class);
        Observable<ShopBean> shop = apiService.getShop(userId, sessionId);
        shop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean value) {
                        List<ResultBean> result = value.getResult();
                        shopCallBack.CallBack(result);
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
