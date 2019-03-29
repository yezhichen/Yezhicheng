package com.bawei.electricityproject.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.adapter.DetailedAdapter;
import com.bawei.electricityproject.base.BaseActivity;
import com.bawei.electricityproject.bean.AddBean;
import com.bawei.electricityproject.bean.DetailedBean;
import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.contract.AddShopContract;
import com.bawei.electricityproject.contract.DetailedContract;
import com.bawei.electricityproject.contract.ShopTowContract;
import com.bawei.electricityproject.presenter.AddShopPresenter;
import com.bawei.electricityproject.presenter.DetailedPresenter;
import com.bawei.electricityproject.presenter.ShopTwoPresenter;
import com.bawei.electricityproject.view.Search;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailedActivity extends BaseActivity implements DetailedContract.DetailedView, View.OnClickListener, ShopTowContract.ShopTowView, AddShopContract.AddShopView {

    private DetailedPresenter detailedPresenter;
    private SharedPreferences sp;
    private TextView shop_price;
    private TextView name;
    private TextView num;
    private ViewPager pager;
    private TextView numbre;
    private ArrayList<ImageView> imageViews;
    private String[] split;
    private WebView webView;
    private ImageView back;
    private ImageView add_shop;
    private ImageView buy;
    private ShopTwoPresenter shopTwoPresenter;
    private String userId;
    private String sessionId;
    private int commodityId;
    private AddShopPresenter addShopPresenter;
    private int saleNum;
    private int price;
    private String commodityName;
    private String img;

    @Override
    protected int layoutID() {
        return R.layout.activity_detailed;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("jzmm", Context.MODE_PRIVATE);
        shop_price = findViewById(R.id.shoopprice);
        name = findViewById(R.id.shoopname);
        num = findViewById(R.id.shoopnum);
        pager = findViewById(R.id.pager);
        numbre = findViewById(R.id.numbre);
        webView = findViewById(R.id.webView);
        back = findViewById(R.id.back);
        add_shop = findViewById(R.id.add_shop);
        buy = findViewById(R.id.buy);
        add_shop.setOnClickListener(this);
        buy.setOnClickListener(this);
        back.setOnClickListener(this);
        detailedPresenter = new DetailedPresenter();
        detailedPresenter.attachView(this);
        shopTwoPresenter = new ShopTwoPresenter();
        shopTwoPresenter.attachView(this);
        addShopPresenter = new AddShopPresenter();
        addShopPresenter.attachView(this);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        userId = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");
        Log.i("sisi", "initData: " + sessionId);
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        detailedPresenter.requestModel(id, userId, sessionId);
    }

    @Override
    public void detailedData(DetailedBean.ResultBean result) {
        commodityName = result.getCommodityName();
        saleNum = result.getSaleNum();
        price = result.getPrice();
        String details = result.getDetails();
        commodityId = result.getCommodityId();
        /*webView.loadData(details, "text/html; charset=UTF-8", null);

        //webview的自适应屏幕
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);*/
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String s = "<script type=\"text/javascript\">" +

                "var imgs=document.getElementsByTagName('img');" +
                "for(var i = 0; i<imgs.length; i++){" +
                "imgs[i].style.width='100%';" +
                "imgs[i].style.height='auto';" +
                "}" +
                "</script>";
        webView.loadDataWithBaseURL(null, details + s + "<html><body>", "text/html", "utf-8", null);
        name.setText(commodityName);
        num.setText("已售" + saleNum + "件");
        shop_price.setText("￥:" + price);
        imageViews = new ArrayList<>();
        String picture = result.getPicture();
        split = picture.split(",");

        for (int i = 0; i < split.length; i++) {
            ImageView imageView = new ImageView(DetailedActivity.this);
            Glide.with(DetailedActivity.this).load(split[i]).into(imageView);
            imageViews.add(imageView);
            DetailedAdapter detailedAdapter = new DetailedAdapter(DetailedActivity.this, imageViews);
            pager.setAdapter(detailedAdapter);

        }
        img = split[0];

        int i = pager.getCurrentItem() + 1;
        numbre.setText(i + "/" + split.length);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int ii = pager.getCurrentItem() + 1;
                numbre.setText(ii + "/" + split.length);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_shop:
                shopTwoPresenter.requestModel(userId, sessionId);
                Toast.makeText(this, "同步成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buy:
                Intent intent = new Intent(this, CreatOder.class);
                intent.putExtra("userId", userId);
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("price", price+"");
                intent.putExtra("commodityId", commodityId);
                intent.putExtra("commodityName", commodityName);
                intent.putExtra("img", img);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public void ShopData(List<ResultBean> result) {
        List<AddBean> beans = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            beans.add(new AddBean(result.get(i).getCommodityId(), 1));
        }
        beans.add(new AddBean(commodityId, 1));
        Gson gson = new Gson();
        String data = gson.toJson(beans);
        addShopPresenter.requestModel(userId, sessionId, data);
    }

    @Override
    public void AddShopData(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
