package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.AddressBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/29.
 */
public interface OderContract {
    //v层：接收传到v的方法
    public interface OderView{
        public void oderData();
    }
    //p层
    public interface OderPresenter{
        //与v交互的方法
        public void attachView(OderContract.OderView oderView);
        //处理数据的方法
        public void requestModel();
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface MyAddressModel{
        public void response( MyAddressCallBack addressCallBack);
        //回调的接口
        public interface MyAddressCallBack{
            public void CallBack();
        }
    }
}
