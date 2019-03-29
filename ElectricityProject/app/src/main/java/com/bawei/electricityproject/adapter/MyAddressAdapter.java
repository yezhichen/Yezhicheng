package com.bawei.electricityproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.electricityproject.R;
import com.bawei.electricityproject.bean.AddressBean;

import java.util.List;

/**
 * Created by 叶至成 on 2019/3/29.
 */
public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.AddressViewHolder>{
    private Context context;
    private List<AddressBean.ResultBean> result;

    public MyAddressAdapter(Context context, List<AddressBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.address_item, viewGroup, false);
        AddressViewHolder viewHolder = new AddressViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder addressViewHolder, int i) {
        String address = result.get(i).getAddress();
        String realName = result.get(i).getRealName();
        long createTime = result.get(i).getCreateTime();
        addressViewHolder.address.setText(address);
        addressViewHolder.date.setText(createTime+"");
        addressViewHolder.name.setText(realName);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class AddressViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView date;
        private final TextView address;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            address = itemView.findViewById(R.id.address);
        }
    }
}
