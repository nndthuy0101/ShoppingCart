package com.diemthuy.shoppingcart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.ProductItem;

import java.util.List;

public class ProductARAdapter extends RecyclerView.Adapter<ProductARAdapter.ViewHolder> {
    private List<ProductItem> list;

    public ProductARAdapter(List<ProductItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_ar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem item = list.get(position);
        holder.title.setText(item.title);
        holder.image.setImageResource(item.imageRes);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgProduct);
            title = itemView.findViewById(R.id.txtTitle);
        }
    }
}
