package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.AddressBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/29.
 */
public interface MyAddressContract {
    //v层：接收传到v的方法
    public interface MyAddressView{
        public void addressData(List<AddressBean.ResultBean> result);
    }
    //p层
    public interface MyAddressPresenter{
        //与v交互的方法
        public void attachView(MyAddressContract.MyAddressView myAddressView);
        //处理数据的方法
        public void requestModel(String userId, String sessionId);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface MyAddressModel{
        public void response(String userId, String sessionId, MyAddressCallBack addressCallBack);
        //回调的接口
        public interface MyAddressCallBack{
            public void CallBack(List<AddressBean.ResultBean> result);
        }
    }
}
