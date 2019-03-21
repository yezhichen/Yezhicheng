package com.bawei.electricityproject.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.contract.DetailedContract;
import com.bawei.electricityproject.presenter.DetailedPresenter;

public class DetailedActivity extends BaseActivity implements DetailedContract.DetailedView {

    private DetailedPresenter detailedPresenter;

    @Override
    protected int layoutID() {
        return R.layout.activity_detailed;
    }

    @Override
    protected void initView() {
        TextView shop_price = findViewById(R.id.shoopprice);
        TextView name = findViewById(R.id.shoopname);
        TextView num = findViewById(R.id.shoopnum);
        ViewPager pager = findViewById(R.id.pager);
        TextView numbre = findViewById(R.id.numbre);
        detailedPresenter = new DetailedPresenter();
        detailedPresenter.attachView(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        detailedPresenter.requestModel(id);
    }

    @Override
    public void detailedData() {

    }
}
