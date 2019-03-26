package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.contract.ShopContract;
import com.bawei.electricityproject.model.ShopModel;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public class ShopPresenter implements ShopContract.ShopPresenter {
    ShopContract.ShopView shopView;
    private ShopModel shopModel;

    @Override
    public void attachView(ShopContract.ShopView shopView) {
        this.shopView =shopView;
        shopModel = new ShopModel();
    }

    @Override
    public void requestModel(String userId, String sessionId) {
        shopModel.response(userId,sessionId,new ShopContract.ShopModel.ShopCallBack() {
            @Override
            public void CallBack(List<ResultBean> result) {
                shopView.ShopData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
