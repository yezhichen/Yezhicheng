package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.DetailedBean;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public interface DetailedContract {
    //v层：接收传到v的方法
    public interface DetailedView{
        public void detailedData(DetailedBean.ResultBean result);
    }
    //p层
    public interface DetailedPresenter{
        //与v交互的方法
        public void attachView(DetailedContract.DetailedView detailedView);
        //处理数据的方法
        public void requestModel(String s, String userId, String id);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface DetailedModel{
        public void response(String s, String userId, String id, DetailedCallBack callBack);
        //回调的接口
        public interface DetailedCallBack{
            public void CallBack(DetailedBean.ResultBean result);
        }
    }
}
