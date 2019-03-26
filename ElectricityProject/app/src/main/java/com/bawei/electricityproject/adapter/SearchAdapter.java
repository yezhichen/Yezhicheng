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
import com.bawei.electricityproject.bean.KeyWordBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/24.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>{
    private Context context;
    private List<KeyWordBean.ResultBean> result;
    private int commodityId;

    public SearchAdapter(Context context, List<KeyWordBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String masterPic = result.get(i).getMasterPic();
        String commodityName = result.get(i).getCommodityName();
        commodityId = result.get(i).getCommodityId();
        int price = result.get(i).getPrice();
        myViewHolder.s_title.setText(commodityName);
        myViewHolder.s_price.setText("￥:"+price);
        Uri uri = Uri.parse(masterPic);
        myViewHolder.img.setImageURI(uri);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onCklic(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView s_price;
        private final TextView s_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.search_img);
            s_price = itemView.findViewById(R.id.search_price);
            s_title = itemView.findViewById(R.id.search_title);
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
