package com.bawei.electricityproject.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.activity.MyAddress;
import com.bawei.electricityproject.base.BaseFragment;

/**
 * Created by 叶至成 on 2019/3/20.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private TextView myuser;

    @Override
    protected int layoutID() {
        return R.layout.myfrag;
    }

    @Override
    protected void initView(View view) {
        TextView myuser = view.findViewById(R.id.myuser);
        TextView myircle = view.findViewById(R.id.mycircle);
        TextView myoot = view.findViewById(R.id.myfoot);
        TextView mywalle = view.findViewById(R.id.mywalle);
        TextView myaddress = view.findViewById(R.id.myaddress);
        myuser.setOnClickListener(this);
        myircle.setOnClickListener(this);
        myoot.setOnClickListener(this);
        mywalle.setOnClickListener(this);
        myaddress.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myuser:
                break;
            case R.id.mycircle:
                break;
            case R.id.myfoot:
                break;
            case R.id.mywalle:
                break;
            case R.id.myaddress:
                Intent intent = new Intent(getContext(), MyAddress.class);
                startActivity(intent);
                break;
        }
    }
}
