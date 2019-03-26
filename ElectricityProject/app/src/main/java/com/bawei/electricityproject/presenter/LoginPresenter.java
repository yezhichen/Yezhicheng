package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.contract.LoginContract;
import com.bawei.electricityproject.model.LoginModel;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class LoginPresenter implements LoginContract.LoginPresenter {
    LoginContract.LoginView loginView;
    private LoginModel loginModel;

    //获取v层
    @Override
    public void attachView(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }
//c
    @Override
    public void requestModel(String login_phone, String login_pwd) {
        loginModel.response(login_phone, login_pwd, new LoginContract.LoginModel.callBack() {
            @Override
            public void back(String s, String status, int userId) {
                loginView.LoginData(status,s,userId);
            }
        });
    }
//销毁
    @Override
    public void des() {

    }
}
