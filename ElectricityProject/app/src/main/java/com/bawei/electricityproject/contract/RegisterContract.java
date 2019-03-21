package com.bawei.electricityproject.contract;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public interface RegisterContract {
    //v层
    public interface RegisterView{
        //接收传到v层的方法
        public void registerData(String status);
    }
    //p层
    public interface RegisterPresenter{
        //p与v交互的方法
        public void attachView(RegisterContract.RegisterView registerView );
        //处理数据的方法
        public void requestModel(String register_phone, String register_pwd);
        //销毁的方法
        public void destroy();
    }
    //m层
    public interface RegisterModel{
        public void response(String register_phone, String register_pwd, RegisterCallback callback);
        public interface RegisterCallback{
            public void back(String status);
        }
    }
}
