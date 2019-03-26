package com.bawei.electricityproject.contract;

import com.bawei.electricityproject.bean.KeyWordBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/23.
 */
public interface SearchContract {
    public interface SearchView{
        public void searchData(List<KeyWordBean.ResultBean> result);
    }
    public interface SearchPresenter{
        //与v交互的方法
        public void attachView(SearchContract.SearchView searchView);
        //处理数据的方法
        public void requestModel(String text);
        //销毁的方法
        public void destoy();
    }
    //m层
    public interface SearchModel{
        public void response(String text, SearchCallBack callBack);
        //回调的接口
        public interface SearchCallBack{
            public void CallBack(List<KeyWordBean.ResultBean> result);
        }
    }
}
