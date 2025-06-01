package com.diemthuy.shoppingcart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.LastCollectionItem;

import java.util.List;

public class LastCollectionAdapter extends RecyclerView.Adapter<LastCollectionAdapter.ViewHolder> {

    private List<LastCollectionItem> itemList;

    public LastCollectionAdapter(List<LastCollectionItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_last_collection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LastCollectionItem item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.titleView.setText(item.getTitle());
        holder.priceView.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView, priceView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleView = itemView.findViewById(R.id.item_title);
            priceView = itemView.findViewById(R.id.item_price);
        }
    }
}
