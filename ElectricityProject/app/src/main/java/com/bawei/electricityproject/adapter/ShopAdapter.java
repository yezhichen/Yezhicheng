package com.bawei.electricityproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.bean.ResultBean;
import com.bawei.electricityproject.bean.ShopBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    private Context context;
    private List<ResultBean> result;

    public ShopAdapter(Context context, List<ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String commodityName = result.get(i).getCommodityName();
        String pic = result.get(i).getPic();
        int price = result.get(i).getPrice();
        myViewHolder.shop_title.setText(commodityName);
        myViewHolder.shop_price.setText(price+"");
        Uri uri = Uri.parse(pic);
        myViewHolder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;
        private final SimpleDraweeView img;
        private final TextView shop_title;
        private final TextView shop_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.check);
            img = itemView.findViewById(R.id.shop_img);
            shop_title = itemView.findViewById(R.id.shop_title);
            shop_price = itemView.findViewById(R.id.shop_price);
        }
    }
}
