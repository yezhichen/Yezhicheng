package com.bawei.electricityproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/21.
 */
public class LifeAdapter extends RecyclerView.Adapter<LifeAdapter.MyViewHolder3>{
    private Context context;
    private List<ShowBean.ResultBean.MlssBean.CommodityListBean> commodityList2;

    public LifeAdapter(Context context, List<ShowBean.ResultBean.MlssBean.CommodityListBean> commodityList2) {
        this.context = context;
        this.commodityList2 = commodityList2;
    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.life_show, viewGroup, false);
        MyViewHolder3 myViewHolder = new MyViewHolder3(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 myViewHolder3, int i) {
        String masterPic = commodityList2.get(i).getMasterPic();
        String commodityName = commodityList2.get(i).getCommodityName();
        int price = commodityList2.get(i).getPrice();
        String s = Integer.toString(price);
        myViewHolder3.price.setText("￥："+s);
        myViewHolder3.title.setText(commodityName);
        Uri uri = Uri.parse(masterPic);
        myViewHolder3.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return commodityList2.size();
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView price;
        private final SimpleDraweeView img;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.life_img);
            price = itemView.findViewById(R.id.life_price);
            title = itemView.findViewById(R.id.life_title);
        }
    }
}
