package com.bawei.electricityproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @Override
    protected int layoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
