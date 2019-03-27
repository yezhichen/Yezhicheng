package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.ResultBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public interface ShopTowContract {
    public interface ShopTowView{
        public void ShopData(List<ResultBean> result);
    }
    public interface ShopTowPresenter{
        //与v交互的方法
        public void attachView(ShopTowContract.ShopTowView shopTowView);
        //处理数据的方法
        public void requestModel(String userId, String sessionId);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface ShopTowModel{
        public void response(String userId, String sessionId, ShopContract.ShopModel.ShopCallBack shopCallBack);
        //回调的接口
        public interface ShopCallBack{
            public void CallBack();
        }
    }
}
