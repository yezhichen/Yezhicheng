package com.bawei.electricityproject.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.MyAddressAdapter;
import com.bawei.electricityproject.api.ApiService;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.bean.AddressBean;
import com.bawei.electricityproject.contract.MyAddressContract;
import com.bawei.electricityproject.presenter.MyAddressPresenter;
import com.bawei.electricityproject.utils.RetrofitUtils2;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CreatOder extends BaseActivity  {

    private MyAddressPresenter addressPresenter;
    private MyAddressAdapter myAddressAdapter;
    private String userId;
    private String sessionId;
    @Override
    protected int layoutID() {
        return R.layout.activity_creat_oder;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");
        sessionId = intent.getStringExtra("sessionId");
        String price = intent.getStringExtra("price");
        String commodityId = intent.getStringExtra("commodityId");
        String commodityName = intent.getStringExtra("commodityName");
        String img = intent.getStringExtra("img");

        SimpleDraweeView o_img = findViewById(R.id.oder_img);
        TextView o_price = findViewById(R.id.oder_price);
        TextView o_title = findViewById(R.id.oder_title);
        Uri uri = Uri.parse(img);
        o_img.setImageURI(uri);
        o_price.setText(price);
        o_title.setText(commodityName);

    }

    @Override
    protected void initData() {

    }


}
