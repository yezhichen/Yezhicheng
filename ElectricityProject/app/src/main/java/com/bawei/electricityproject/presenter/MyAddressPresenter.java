package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.AddressBean;
import com.bawei.electricityproject.contract.MyAddressContract;
import com.bawei.electricityproject.model.MyAddressModel;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/29.
 */
public class MyAddressPresenter implements MyAddressContract.MyAddressPresenter {
    MyAddressContract.MyAddressView myAddressView;
    private MyAddressModel myAddressModel;

    @Override
    public void attachView(MyAddressContract.MyAddressView myAddressView) {
        this.myAddressView = myAddressView;
        myAddressModel = new MyAddressModel();
    }

    @Override
    public void requestModel(String userId, String sessionId) {
        myAddressModel.response(userId,sessionId,new MyAddressContract.MyAddressModel.MyAddressCallBack() {
            @Override
            public void CallBack(List<AddressBean.ResultBean> result) {
                myAddressView.addressData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
