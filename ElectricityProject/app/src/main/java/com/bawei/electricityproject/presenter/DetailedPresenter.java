package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.DetailedBean;
import com.bawei.electricityproject.contract.DetailedContract;
import com.bawei.electricityproject.model.DetailedModel;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class DetailedPresenter implements DetailedContract.DetailedPresenter {
    DetailedContract.DetailedView detailedView;
    private DetailedModel detailedModel;

    @Override
    public void attachView(DetailedContract.DetailedView detailedView) {
        this.detailedView = detailedView;
        detailedModel = new DetailedModel();
    }

    @Override
    public void requestModel(String s, String userId, String id) {
        detailedModel.response(id,userId,s,new DetailedContract.DetailedModel.DetailedCallBack() {
            @Override
            public void CallBack(DetailedBean.ResultBean result) {
                detailedView.detailedData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
