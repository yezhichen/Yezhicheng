package com.bawei.electricityproject.presenter;

import com.bawei.electricityproject.bean.BannerBean;
import com.bawei.electricityproject.contract.BannerContract;
import com.bawei.electricityproject.model.BannerModel;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class BannerPresenter implements BannerContract.BannerPresenter {
    BannerContract.BannerView bannerView;
    private BannerModel bannerModel;

    @Override
    public void attachView(BannerContract.BannerView bannerView) {
        this.bannerView = bannerView;
        bannerModel = new BannerModel();
    }

    @Override
    public void requestModel() {
        bannerModel.response(new BannerContract.BannerModel.BannerCallBack() {
            @Override
            public void CallBack(List<BannerBean.ResultBean> result) {
                bannerView.bannerData(result);
            }
        });
    }

    @Override
    public void destoy() {

    }
}
