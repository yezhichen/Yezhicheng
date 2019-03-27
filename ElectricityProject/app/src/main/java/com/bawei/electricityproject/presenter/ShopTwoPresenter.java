package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.contract.ShopContract;
import com.bawei.electricityproject.contract.ShopTowContract;
import com.bawei.electricityproject.model.ShopTowModel;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public class ShopTwoPresenter implements ShopTowContract.ShopTowPresenter {
    ShopTowContract.ShopTowView shopTowView;
    private ShopTowModel shopTowModel;

    @Override
    public void attachView(ShopTowContract.ShopTowView shopTowView) {
        this.shopTowView = shopTowView;
        shopTowModel = new ShopTowModel();
    }

    @Override
    public void requestModel(String userId, String sessionId) {
        shopTowModel.response(userId, sessionId, new ShopContract.ShopModel.ShopCallBack() {
            @Override
            public void CallBack(List<ResultBean> result) {
                shopTowView.ShopData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
