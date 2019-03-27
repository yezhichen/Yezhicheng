package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.contract.AddShopContract;
import com.bawei.electricityproject.model.AddShopModel;

/**
 * Created by 叶至成 on 2019/3/27.
 */
public class AddShopPresenter implements AddShopContract.AddShopPresenter {
    AddShopContract.AddShopView addShopView;
    private AddShopModel addShopModel;

    @Override
    public void attachView(AddShopContract.AddShopView addShopView) {
        this.addShopView = addShopView;
        addShopModel = new AddShopModel();
    }

    @Override
    public void requestModel(String userId, String sessionId, String data) {
        addShopModel.response(userId,sessionId,data,new AddShopContract.AddShopModel.AddShopCallBack() {
            @Override
            public void CallBack(String message) {
                addShopView.AddShopData(message);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
