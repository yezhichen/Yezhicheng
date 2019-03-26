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
public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.MyViewHolder2>{
   private Context context;
   private List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1;

    public FashionAdapter(Context context, List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1) {
        this.context = context;
        this.commodityList1 = commodityList1;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.life_show, viewGroup, false);
        MyViewHolder2 myViewHolder = new MyViewHolder2(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 myViewHolder2, int i) {
        String masterPic = commodityList1.get(i).getMasterPic();
        String commodityName = commodityList1.get(i).getCommodityName();
        int price = commodityList1.get(i).getPrice();
        final int commodityId = commodityList1.get(i).getCommodityId();
        String s = Integer.toString(price);
        myViewHolder2.price.setText("￥："+s);
        myViewHolder2.title.setText(commodityName);
        Uri uri = Uri.parse(masterPic);
        myViewHolder2.img.setImageURI(uri);
        myViewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onCklic(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList1.size();
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final TextView price;
        private final TextView title;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.life_img);
            price = itemView.findViewById(R.id.life_price);
            title = itemView.findViewById(R.id.life_title);
        }
    }
    public interface onItemClickListener{
        void onCklic(int i);
    }
    private HotAdapter.onItemClickListener itemClickListener;

    public void setItemClickListener(HotAdapter.onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
