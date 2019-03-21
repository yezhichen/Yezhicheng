package com.bawei.electricityproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.bean.ShowBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.MyViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean.RxxpBean.CommodityListBeanXX> commodityList;

    public HotAdapter(Context context, List<ShowBean.ResultBean.RxxpBean.CommodityListBeanXX> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_show, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        String masterPic = commodityList.get(i).getMasterPic();
        String commodityName = commodityList.get(i).getCommodityName();
       final int commodityId = commodityList.get(i).getCommodityId();

        int price = commodityList.get(i).getPrice();
        String s = Integer.toString(price);
        myViewHolder.price.setText("￥："+s);
        myViewHolder.title.setText(commodityName);
        Uri uri = Uri.parse(masterPic);
        myViewHolder.img.setImageURI(uri);
        //接口回调条目的id去拼接详情页面
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onCklic(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView price;
        private final TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.hot_img);
            price = itemView.findViewById(R.id.hot_price);
            title = itemView.findViewById(R.id.hot_title);
        }
    }
    public interface onItemClickListener{
        void onCklic(int i);
    }
    private onItemClickListener itemClickListener;

    public void setItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
