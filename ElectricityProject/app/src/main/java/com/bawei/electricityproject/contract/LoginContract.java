package com.bawei.electricityproject.contract;

/**
 * Created by 叶至成 on 2019/3/20.
 * 登录契约类
 */
public interface LoginContract {
    //v层
    public interface LoginView{
        //这个方法是回调到v层的
        public void LoginData(String s, String status, int userId);
    }
    //p层
    public interface LoginPresenter{

        public void attachView(LoginContract.LoginView loginView);
        public void requestModel(String login_phone, String login_pwd);
        public void des();
    }
    //m层
    public interface LoginModel{
        public void response(String login_phone, String login_pwd,callBack back);
        public interface callBack{
            public void back(String s, String status, int userId);
        };
    }
}
