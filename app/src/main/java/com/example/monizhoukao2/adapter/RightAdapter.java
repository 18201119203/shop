package com.example.monizhoukao2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.monizhoukao2.R;
import com.example.monizhoukao2.bean.RightBean;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context context;
    private List<RightBean.getData> list;

    public RightAdapter(Context context) {
        this.context = context;

    }

    public void setList(List<RightBean.getData> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.right_item, parent, false);
        RightAdapter.ViewHolder viewHolder = new RightAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).name);
        holder.rv.setLayoutManager(new GridLayoutManager(context,3));
        holder.rv.setAdapter(new RightItemAdapter(context,list.get(position).list));

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            rv = itemView.findViewById(R.id.rv);
        }
    }

}
