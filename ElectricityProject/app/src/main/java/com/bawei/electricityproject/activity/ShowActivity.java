package com.bawei.electricityproject.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.fragment.CircleFragment;
import com.bawei.electricityproject.fragment.HomeFragment;
import com.bawei.electricityproject.fragment.MyFragment;
import com.bawei.electricityproject.fragment.OderFragment;
import com.bawei.electricityproject.fragment.ShoppingCarFragment;

public class ShowActivity extends BaseActivity {

    private FrameLayout frame;
    private RadioGroup show_rg;

    @Override
    protected int layoutID() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        frame = findViewById(R.id.frame);
        show_rg = findViewById(R.id.show_rg);
    }

    @Override
    protected void initData() {
        //获取布局管理器
        final FragmentManager manager = getSupportFragmentManager();
        //开启事务
        final FragmentTransaction transaction = manager.beginTransaction();
        //添加布局
        final HomeFragment homeFragment = new HomeFragment();
        final CircleFragment circleFragment = new CircleFragment();
        final ShoppingCarFragment shoppingCarFragment = new ShoppingCarFragment();
        final OderFragment oderFragment = new OderFragment();
        final MyFragment myFragment = new MyFragment();

        transaction.add(R.id.frame, homeFragment);
        transaction.add(R.id.frame, circleFragment);
        transaction.add(R.id.frame, shoppingCarFragment);
        transaction.add(R.id.frame, oderFragment);
        transaction.add(R.id.frame, myFragment);
        transaction.show(homeFragment).hide(circleFragment)
                .hide(shoppingCarFragment)
                .hide(oderFragment)
                .hide(myFragment);
        transaction.commit();
        show_rg.check(R.id.home_frag);
        show_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction qq = manager.beginTransaction();
                switch (checkedId){
                    case R.id.home_frag:
                        qq.show(homeFragment).hide(circleFragment)
                                .hide(shoppingCarFragment)
                                .hide(oderFragment)
                                .hide(myFragment);
                        break;
                    case R.id.circle_frag:
                        qq.show(circleFragment).hide(homeFragment)
                                .hide(shoppingCarFragment)
                                .hide(oderFragment)
                                .hide(myFragment);
                        break;
                    case R.id.shopping_frag:
                        qq.show(shoppingCarFragment).hide(homeFragment)
                                .hide(circleFragment)
                                .hide(oderFragment)
                                .hide(myFragment);
                        break;
                    case R.id.ding_frag:
                        qq.show(oderFragment).hide(homeFragment)
                                .hide(circleFragment)
                                .hide(shoppingCarFragment)
                                .hide(myFragment);
                        break;
                    case R.id.my_frag:
                        qq.show(myFragment).hide(homeFragment)
                                .hide(circleFragment)
                                .hide(shoppingCarFragment)
                                .hide(oderFragment);
                        break;
                }
                qq.commit();
            }
        });
    }
}
