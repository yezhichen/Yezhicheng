package com.bawei.electricityproject.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.activity.DetailedActivity;
import com.bawei.electricityproject.adapter.FashionAdapter;
import com.bawei.electricityproject.adapter.HotAdapter;
import com.bawei.electricityproject.adapter.LifeAdapter;
import com.bawei.electricityproject.base.BaseFragment;
import com.bawei.electricityproject.bean.BannerBean;
import com.bawei.electricityproject.bean.ShowBean;
import com.bawei.electricityproject.contract.BannerContract;
import com.bawei.electricityproject.contract.HotContract;
import com.bawei.electricityproject.presenter.BannerPresenter;
import com.bawei.electricityproject.presenter.HotPresenter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class HomeFragment extends BaseFragment implements BannerContract.BannerView,HotContract.HotView {

    private XBanner xBanner;
    private BannerPresenter bannerPresenter;
    //创建集合存banner的图片字符
    private ArrayList<String> banner_list = new ArrayList<>();
    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private HotPresenter hotPresenter;

    @Override
    protected int layoutID() {
        return R.layout.homefrag;
    }

    @Override
    protected void initView(View view) {
        xBanner = view.findViewById(R.id.xbanner);
        bannerPresenter = new BannerPresenter();
        rv1 = view.findViewById(R.id.rv1);
        rv2 = view.findViewById(R.id.rv2);
        rv3 = view.findViewById(R.id.rv3);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rv1.setLayoutManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 2);
        rv3.setLayoutManager(gridLayoutManager1);
        rv2.setLayoutManager(linearLayoutManager);

        hotPresenter = new HotPresenter();
    }

    @Override
    protected void initData() {
        bannerPresenter.attachView(this);
        bannerPresenter.requestModel();

        hotPresenter.attachView(this);
        hotPresenter.requestModel();

    }

    @Override
    public void bannerData(List<BannerBean.ResultBean> result) {
        for (int i = 0; i < result.size(); i++) {
            String imageUrl = result.get(i).getImageUrl();
            banner_list.add(imageUrl);
        }
        xBanner.setData(banner_list, null);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getContext()).load(banner_list.get(position)).into((ImageView) view);
            }
        });
    }


    @Override
    public void hotData(ShowBean.ResultBean result) {
        ShowBean.ResultBean.RxxpBean rxxp = result.getRxxp();
        List<ShowBean.ResultBean.RxxpBean.CommodityListBeanXX> commodityList = rxxp.getCommodityList();
       HotAdapter hotAdapter = new HotAdapter(getContext(), commodityList);
        rv1.setAdapter(hotAdapter);
        hotAdapter.setItemClickListener(new HotAdapter.onItemClickListener() {
            @Override
            public void onCklic(int i) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("id",""+i);
                startActivity(intent);
            }
        });

        ShowBean.ResultBean.PzshBean pzsh = result.getPzsh();
        List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = pzsh.getCommodityList();
       FashionAdapter fashionAdapter = new FashionAdapter(getContext(), commodityList1);


        ShowBean.ResultBean.MlssBean mlss = result.getMlss();
        List<ShowBean.ResultBean.MlssBean.CommodityListBean> commodityList2 = mlss.getCommodityList();
       LifeAdapter lifeAdapter = new LifeAdapter(getContext(), commodityList2);
        rv2.setAdapter(fashionAdapter);
        rv3.setAdapter(lifeAdapter);
    }

}
