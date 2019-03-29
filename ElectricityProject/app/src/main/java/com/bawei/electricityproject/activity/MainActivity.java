package com.bawei.electricityproject.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.contract.LoginContract;
import com.bawei.electricityproject.presenter.LoginPresenter;
import com.bawei.electricityproject.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener, LoginContract.LoginView {

    private EditText login_phone;
    private EditText login_pwd;
    private CheckBox reb_pwd;
    private TextView login_register;
    private Button login;
    private LoginPresenter loginPresenter;
    private SharedPreferences sp;

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //创建sharedpreference
        sp = getSharedPreferences("jzmm", Context.MODE_PRIVATE);
        login_phone = findViewById(R.id.login_phone);
        login_pwd = findViewById(R.id.login_pwd);
        reb_pwd = findViewById(R.id.reb_pwd);
        login_register = findViewById(R.id.login_register);
        login = findViewById(R.id.login);
        reb_pwd.setOnClickListener(this);
        login_register.setOnClickListener(this);
        login.setOnClickListener(this);
        loginPresenter = new LoginPresenter();
    }

    @Override
    protected void initData() {
        if (sp.getBoolean("记住密码",false)){
            String phone = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            login_phone.setText(phone);
            login_pwd.setText(pwd);
            reb_pwd.setChecked(true);
        }
        loginPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                //点击登录获取输入框内容
                String login_phone = this.login_phone.getText().toString().trim();
                String login_pwd = this.login_pwd.getText().toString().trim();
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("记住密码",reb_pwd.isChecked());
                edit.putString("phone",login_phone);
                edit.putString("pwd",login_pwd);

                edit.commit();
                boolean mobileNO = Utils.isMobileNO(login_phone);
                if (!mobileNO) {
                    Toast.makeText(this, "手机号不正规", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (login_pwd.length() < 3) {
                    Toast.makeText(this, "密码不正规", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginPresenter.requestModel(login_phone, login_pwd);
                break;
                //快速注册
            case R.id.login_register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
    //回调数据


    @Override
    public void LoginData(String s, String status, int userId) {
        Log.i("userId", userId+"LoginData: "+s);
        if (status.equals("0000")) {
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            startActivity(intent);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor edit = sp.edit();
            String userI = Integer.toString(userId);
            edit.putString("userId",userI);
            edit.putString("sessionId",s);
            edit.commit();
            finish();
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
