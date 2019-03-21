package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.ShowBean;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public interface HotContract {
    public interface HotView{
        public void hotData(ShowBean.ResultBean result);
    }
    public interface HotPresenter{
        //与v交互的方法
        public void attachView(HotContract.HotView hotView);
        //处理数据的方法
        public void requestModel();
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface BannerModel{
        public void response(HotCallBack callBack);
        //回调的接口
        public interface HotCallBack{
            public void CallBack(ShowBean.ResultBean result);
        }
    }
}
