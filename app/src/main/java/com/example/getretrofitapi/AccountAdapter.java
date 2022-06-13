package com.example.getretrofitapi;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getretrofitapi.databinding.SingleRowBinding;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AccountAdapter extends RecyclerView.Adapter <AccountAdapter.MyViewHolder> {

    private final List <AData> dataList;


    public AccountAdapter(List <AData> dataList) {
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SingleRowBinding singleRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.single_row, parent, false);

        return new MyViewHolder(singleRowBinding);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AData data = dataList.get(position);
        holder.singleRowBinding.tvAccountName.setText(data.getAccountname());
        holder.singleRowBinding.tvAccountNameTH.setText(data.getAccountNameTH());
        holder.singleRowBinding.tvDivisionValue.setText(data.getDivisionValue());
        holder.singleRowBinding.tvCategory.setText(data.getCategory());
        holder.singleRowBinding.tvAccountType.setText(data.getAccountType());
        holder.singleRowBinding.tvAddress.setText(data.getAddress());
        /// Use the glide and picasso library for image loading
        if (!data.getAccountImage().isEmpty()) {
            holder.singleRowBinding.imageLayout.setVisibility(View.VISIBLE);
            Picasso.get().load(data.getAccountImage())
                    .into(holder.singleRowBinding.accountImage);
        } else {
            Log.e("Account Image", " Getting the empty image from response");

        }

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        SingleRowBinding singleRowBinding;

        public MyViewHolder(SingleRowBinding singleRowBinding) {
            super(singleRowBinding.getRoot());
            this.singleRowBinding = singleRowBinding;
        }
    }
}
