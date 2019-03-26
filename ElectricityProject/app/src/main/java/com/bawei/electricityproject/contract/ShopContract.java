package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.ResultBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public interface ShopContract {
    public interface ShopView{
        public void ShopData(List<ResultBean> result);
    }
    public interface ShopPresenter{
        //与v交互的方法
        public void attachView(ShopContract.ShopView shopView);
        //处理数据的方法
        public void requestModel(String userId, String sessionId);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface ShopModel{
        public void response(String userId, String sessionId, ShopCallBack shopCallBack);
        //回调的接口
        public interface ShopCallBack{
            public void CallBack(List<ResultBean> result);
        }
    }
}
