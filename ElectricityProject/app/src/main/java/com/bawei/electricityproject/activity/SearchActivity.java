package com.bawei.electricityproject.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.HotAdapter;
import com.bawei.electricityproject.adapter.SearchAdapter;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.bean.KeyWordBean;
import com.bawei.electricityproject.contract.SearchContract;
import com.bawei.electricityproject.presenter.SearchPresenter;
import com.bawei.electricityproject.view.Search;

import java.util.List;

public class SearchActivity extends BaseActivity implements SearchContract.SearchView {

    private Search search;
    private SearchPresenter searchPresenter;
    private RecyclerView rv;
    private Button bt_search;
    private TextView tet;

    @Override
    protected int layoutID() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.serach_rv);
        search = findViewById(R.id.search1);
        bt_search = findViewById(R.id.bt_search);
        tet = findViewById(R.id.et_search);
        searchPresenter = new SearchPresenter();
        searchPresenter.attachView(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tet.getText().toString().trim();
                        searchPresenter.requestModel(text);
            }
        });
    }

    @Override
    public void searchData(List<KeyWordBean.ResultBean> result) {
        SearchAdapter searchAdapter = new SearchAdapter(this, result);
        rv.setAdapter(searchAdapter);
        searchAdapter.setItemClickListener(new HotAdapter.onItemClickListener() {
            @Override
            public void onCklic(int i) {
                Toast.makeText(SearchActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SearchActivity.this, DetailedActivity.class);
                intent.putExtra("id",""+i);
                startActivity(intent);
            }
        });
    }
}
