package com.bawei.electricityproject.contract;

/**
 * Created by 叶至成 on 2019/3/27.
 */
public interface AddShopContract {
    public interface AddShopView{
        public void AddShopData(String message);
    }
    public interface AddShopPresenter{
        //与v交互的方法
        public void attachView(AddShopContract.AddShopView addShopView);
        //处理数据的方法
        public void requestModel(String userId, String sessionId, String data);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface AddShopModel{
        public void response(String userId, String sessionId, String data, AddShopCallBack callBack);
        //回调的接口
        public interface AddShopCallBack{
            public void CallBack(String message);
        }
    }
}
