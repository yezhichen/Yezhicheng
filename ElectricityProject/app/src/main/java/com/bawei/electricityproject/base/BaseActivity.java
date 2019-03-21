package com.bawei.electricityproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
        initView();
        initData();
    }

    protected abstract int layoutID();

    protected abstract void initView();

    protected abstract void initData();
}
