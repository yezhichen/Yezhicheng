package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.BannerBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public interface BannerContract {
    //v层：接收传到v的方法
    public interface BannerView{
        public void bannerData(List<BannerBean.ResultBean> result);
    }
    //p层
    public interface BannerPresenter{
        //与v交互的方法
        public void attachView(BannerContract.BannerView bannerView);
        //处理数据的方法
        public void requestModel();
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface BannerModel{
        public void response(BannerCallBack callBack);
        //回调的接口
        public interface BannerCallBack{
            public void CallBack(List<BannerBean.ResultBean> result);
        }
    }
}
