package com.bawei.electricityproject.model;

import android.util.Log;

import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.bean.KeyWordBean;
import com.bawei.electricityproject.contract.SearchContract;
import com.bawei.electricityproject.utils.RetrofitUtils2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 叶至成 on 2019/3/23.
 */
public class SearchModel implements SearchContract.SearchModel {
    @Override
    public void response(String text, final SearchCallBack callBack) {
        ApiService apiService = RetrofitUtils2.getInstance().setCreate(ApiService.class);
        Observable<KeyWordBean> search = apiService.getSearch(text, 1, "" + 100);
        search.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<KeyWordBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(KeyWordBean value) {
                        List<KeyWordBean.ResultBean> result = value.getResult();
                        Log.i("qqq", "onNext: "+result);
                        callBack.CallBack(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("sss", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
