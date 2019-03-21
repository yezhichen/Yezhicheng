package com.bawei.electricityproject.presenter;


import com.bawei.electricityproject.contract.RegisterContract;
import com.bawei.electricityproject.model.RegisterModel;



/**
 * Created by 叶至成 on 2019/3/21.
 */
public class RegisterPresenter implements RegisterContract.RegisterPresenter {
    RegisterContract.RegisterView registerView;
    private RegisterContract.RegisterModel registerModel;

    @Override
    public void attachView(RegisterContract.RegisterView registerView) {
        this.registerView=registerView;
        registerModel = new RegisterModel();
    }

    @Override
    public void requestModel(String register_phone, String register_pwd) {
        registerModel.response(register_phone,register_pwd,new RegisterContract.RegisterModel.RegisterCallback() {
            @Override
            public void back(String status) {
            registerView.registerData(status);
            }
        });
    }


    @Override
    public void destroy() {

    }
}
