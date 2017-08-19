package com.craftnet.mvpdaggerexample.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.craftnet.mvpdaggerexample.Network.Model.Cake;
import com.craftnet.mvpdaggerexample.R;

import java.util.List;

/**
 * Created by shaan on 8/18/2017.
 */

public class AllCakesAdapter extends RecyclerView.Adapter<AllCakesAdapter.ViewHolder> {


    List<Cake>list;
    Context context;

    public AllCakesAdapter(List<Cake> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cake_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cake cake=list.get(position);
        Glide.with(context).load("http://click2cake.com/Admin/CakeMaster/"+cake.getImages()).fitCenter().placeholder(R.drawable.cake).dontAnimate().into(holder.image);
        holder.name.setText(cake.getCakeName());
        if(!cake.getMRP().equals("") && cake.getMRP()!=null){
            holder.price.setText(Html.fromHtml(String.format("<strike><b>Rs %s</b></strike>   &nbsp; <font color='red'><b> Rs %s </b></font>",cake.getMRP(),cake.getRate())));
        }else{
            holder.price.setText(Html.fromHtml(String.format("<font color='red'><b> Rs %s </b></font>",cake.getRate())));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView price;
        private ImageView image;
        public ViewHolder(View view) {
            super(view);
            price=(TextView)view.findViewById(R.id.cakeprice);
            image = (ImageView)view.findViewById(R.id.cakeimage);
            name = (TextView) view.findViewById(R.id.cakename);

        }

    }


}




