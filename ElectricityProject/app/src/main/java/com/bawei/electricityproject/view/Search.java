package com.bawei.electricityproject.view;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.activity.SearchActivity;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class Search extends LinearLayout implements TextWatcher, View.OnClickListener {
    private final Button bt_menu;
    private final EditText et_search;
    private final Button bt_clear;
    private final Button bt_search;

    public Search(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.search,this,true);
        bt_menu = findViewById(R.id.bt_menu);
        et_search = findViewById(R.id.et_search);
       /* et_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchActivity.class);

            }
        });*/
        bt_clear = findViewById(R.id.bt_clear);
        bt_search = findViewById(R.id.bt_search);
        et_search.addTextChangedListener(this);
        bt_clear.setOnClickListener(this);
        bt_search.setOnClickListener(this);
        bt_clear.setVisibility(GONE);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String input = et_search.getText().toString().trim();
        if (input.isEmpty()) {
            bt_clear.setVisibility(GONE);
        } else {
            bt_clear.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_search:

                break;
            case R.id.bt_clear:
                et_search.setText("");
                break;
            case R.id.bt_menu:
                break;
        }
    }
    public interface onSearchLisetener{
        void search(String text);
    }
    private onSearchLisetener searchLisetener;

    public void setSearchLisetener(onSearchLisetener searchLisetener) {
        this.searchLisetener = searchLisetener;
    }
}
