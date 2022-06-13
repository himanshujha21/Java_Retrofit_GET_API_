package com.example.getretrofitapi;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getretrofitapi.databinding.ProductRowBinding;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter <ProductAdapter.MyViewHolder> {

    private final List <PData> dataList;


    public ProductAdapter(List <PData> dataList) {
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductRowBinding singleRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.product_row, parent, false);

        return new MyViewHolder(singleRowBinding);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PData data = dataList.get(position);
        holder.singleRowBinding.tvProductId.setText(data.getProductId());
        holder.singleRowBinding.tvProductName.setText(data.getProductName());
        holder.singleRowBinding.tvProductDivision.setText(data.getDivision());


    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ProductRowBinding singleRowBinding;
        public MyViewHolder(ProductRowBinding singleRowBinding) {
            super(singleRowBinding.getRoot());
            this.singleRowBinding = singleRowBinding;
        }
    }
}
