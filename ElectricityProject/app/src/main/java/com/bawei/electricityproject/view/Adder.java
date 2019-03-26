package com.bawei.electricityproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;

/**
 * Created by 叶至成 on 2019/3/6.
 */
public class Adder extends LinearLayout implements View.OnClickListener {
    private final TextView nums;
    private final Button jia;
    private final Button jian;
    int i = 1;

    public Adder(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.adder, this, true);
        jia = findViewById(R.id.jia);
        nums = findViewById(R.id.nums);
        jian = findViewById(R.id.jian);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jia:
                i++;
                nums.setText(""+i);
                break;
            case R.id.jian:
                if (i>0){
                    i--;
                    nums.setText(""+i);
                }else {
                    Toast.makeText(getContext(), "不能再减了", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
