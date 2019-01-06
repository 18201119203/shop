package com.example.monizhoukao2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.monizhoukao2.R;
import com.example.monizhoukao2.bean.LeftBean;
import com.example.monizhoukao2.bean.RightBean;

import java.util.List;

public class RightItemAdapter  extends RecyclerView.Adapter<RightItemAdapter.ViewHolder> {
    private Context context;
    private List<RightBean.getData.Pcls> list;

    public RightItemAdapter(Context context, List<RightBean.getData.Pcls> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.right_subitem, parent, false);
        RightItemAdapter.ViewHolder viewHolder = new RightItemAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightItemAdapter.ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).name);
        Glide.with(context).load(list.get(position).icon).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            iv  = itemView.findViewById(R.id.iv);
        }
    }


}
