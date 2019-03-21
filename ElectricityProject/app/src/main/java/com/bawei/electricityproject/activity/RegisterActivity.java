package com.bawei.electricityproject.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.contract.RegisterContract;
import com.bawei.electricityproject.presenter.RegisterPresenter;
import com.bawei.electricityproject.utils.Utils;

public class RegisterActivity extends BaseActivity implements View.OnClickListener,RegisterContract.RegisterView {

    private EditText register_phone;
    private EditText register_pwd;
    private TextView register_login;
    private Button register;
    private RegisterPresenter registerPresenter;

    @Override
    protected int layoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        register_phone = findViewById(R.id.register_phone);
        register_pwd = findViewById(R.id.register_pwd);
        register_login = findViewById(R.id.register_login);
        register = findViewById(R.id.register);
        register_login.setOnClickListener(this);
        register.setOnClickListener(this);
        registerPresenter = new RegisterPresenter();
    }

    @Override
    protected void initData() {
        registerPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                String register_phone = this.register_phone.getText().toString().trim();
                String register_pwd = this.register_pwd.getText().toString().trim();
                boolean mobileNO = Utils.isMobileNO(register_phone);
                if (!mobileNO) {
                    Toast.makeText(this, "手机号不正规", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (register_pwd.length() < 3) {
                    Toast.makeText(this, "密码不正规", Toast.LENGTH_SHORT).show();
                    return;
                }
                registerPresenter.requestModel(register_phone,register_pwd);
                break;
            case R.id.register_login:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void registerData(String status) {
        if (status.equals("0000")) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
