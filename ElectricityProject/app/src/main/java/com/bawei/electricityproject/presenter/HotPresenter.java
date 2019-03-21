package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.ShowBean;
import com.bawei.electricityproject.contract.HotContract;
import com.bawei.electricityproject.model.HotModel;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class HotPresenter implements HotContract.HotPresenter {
    HotContract.HotView hotView;
    private HotModel hotModel;

    @Override
    public void attachView(HotContract.HotView hotView) {
        this.hotView = hotView;
        hotModel = new HotModel();
    }

    @Override
    public void requestModel() {
        hotModel.response(new HotContract.BannerModel.HotCallBack() {
            @Override
            public void CallBack(ShowBean.ResultBean result) {
                hotView.hotData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
