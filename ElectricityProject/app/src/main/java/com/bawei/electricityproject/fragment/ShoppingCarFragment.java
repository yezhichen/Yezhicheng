package com.bawei.electricityproject.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.ShopAdapter;
import com.bawei.electricityproject.base.BaseFragment;
import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.contract.ShopContract;
import com.bawei.electricityproject.presenter.ShopPresenter;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class ShoppingCarFragment extends BaseFragment implements ShopContract.ShopView {

    private ShopPresenter shopPresenter;
    private SharedPreferences sp;
    private RecyclerView rv;
    private String userId;
    private String sessionId;

    @Override
    protected int layoutID() {

        return R.layout.shoppingfrag;
    }

    @Override
    protected void initView(View view) {
        sp = getActivity().getSharedPreferences("jzmm", Context.MODE_PRIVATE);
        rv = view.findViewById(R.id.shop_rv);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);
        shopPresenter = new ShopPresenter();
        shopPresenter.attachView(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void ShopData(List<ResultBean> result) {
        ShopAdapter shopAdapter = new ShopAdapter(getContext(), result);
        rv.setAdapter(shopAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        userId = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");
        shopPresenter.requestModel(userId, sessionId);
    }
}
