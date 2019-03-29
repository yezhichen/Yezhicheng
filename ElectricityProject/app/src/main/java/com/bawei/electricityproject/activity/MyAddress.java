package com.bawei.electricityproject.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.MyAddressAdapter;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.bean.AddressBean;
import com.bawei.electricityproject.contract.MyAddressContract;
import com.bawei.electricityproject.presenter.MyAddressPresenter;

import java.util.List;

public class MyAddress extends BaseActivity implements MyAddressContract.MyAddressView {

    private RecyclerView rv;
    private MyAddressPresenter addressPresenter;
    private SharedPreferences sp;

    @Override
    protected int layoutID() {
        return R.layout.activity_my_address;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("jzmm", Context.MODE_PRIVATE);
        rv = findViewById(R.id.rv_address);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        addressPresenter = new MyAddressPresenter();
        addressPresenter.attachView(this);
    }

    @Override
    protected void initData() {
        String userId = sp.getString("userId", "");
        String sessionId = sp.getString("sessionId", "");
        addressPresenter.requestModel(userId,sessionId);
    }

    @Override
    public void addressData(List<AddressBean.ResultBean> result) {
        MyAddressAdapter myAddressAdapter = new MyAddressAdapter(this, result);
        rv.setAdapter(myAddressAdapter);
    }
}
