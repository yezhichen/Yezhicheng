package com.bawei.electricityproject.presenter;

import android.util.Log;
import android.widget.Toast;

import com.bawei.electricityproject.bean.KeyWordBean;
import com.bawei.electricityproject.contract.SearchContract;
import com.bawei.electricityproject.model.SearchModel;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/23.
 */
public class SearchPresenter implements SearchContract.SearchPresenter {
    SearchContract.SearchView searchView;
    private SearchModel searchModel;

    @Override
    public void attachView(SearchContract.SearchView searchView) {
        this.searchView = searchView;
        searchModel = new SearchModel();
    }

    @Override
    public void requestModel(String text) {
        searchModel.response(text,new SearchContract.SearchModel.SearchCallBack() {
            @Override
            public void CallBack(List<KeyWordBean.ResultBean> result) {
                searchView.searchData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
