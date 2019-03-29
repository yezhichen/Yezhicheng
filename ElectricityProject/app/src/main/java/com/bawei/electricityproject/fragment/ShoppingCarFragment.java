package com.bawei.electricityproject.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.ShopAdapter;
import com.bawei.electricityproject.base.BaseFragment;
import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.contract.ShopContract;
import com.bawei.electricityproject.presenter.ShopPresenter;
import com.bawei.electricityproject.view.Adder;

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
    private CheckBox checkAll;
    private TextView sum1;
    private Button payment;
    private ShopAdapter shopAdapter;
    private Adder adder;

    List<ResultBean> result;
    @Override
    protected int layoutID() {

        return R.layout.shoppingfrag;
    }

    @Override
    protected void initView(View view) {
        sp = getActivity().getSharedPreferences("jzmm", Context.MODE_PRIVATE);
        rv = view.findViewById(R.id.shop_rv);
        checkAll = view.findViewById(R.id.checkAll);
        sum1 = view.findViewById(R.id.sum);
        payment = view.findViewById(R.id.payment);
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
    public void ShopData(final List<ResultBean> result) {
        this.result=result;
        shopAdapter = new ShopAdapter(getContext(), result);
        rv.setAdapter(shopAdapter);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < result.size(); i++) {
                    result.get(i).setCheck(checkAll.isChecked());
                }
                shopAdapter.notifyDataSetChanged();

                sumCont();
            }
        });
        shopAdapter.setBackListener(new ShopAdapter.onCallBackListener() {
            @Override
            public void callBack() {
                boolean s = true;
                for (int i = 0; i < result.size(); i++) {
                    boolean check = result.get(i).isCheck();
                    s = s & check;
                }
                checkAll.setChecked(s);
                sumCont();
            }
        });
    }

    public void sumCont() {
        int sum = 0;
        //计算总价
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).isCheck() == true) {
                int price = result.get(i).getPrice();
                sum = sum + price;
            }
            sum1.setText("总价:" + sum);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        userId = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");
        shopPresenter.requestModel(userId, sessionId);
    }

}
