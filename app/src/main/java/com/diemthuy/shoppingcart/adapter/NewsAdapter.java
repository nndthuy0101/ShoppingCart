package com.diemthuy.shoppingcart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.NewsItem;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItem> items;

    public NewsAdapter(List<NewsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        holder.date.setText(item.getDate());
        holder.image.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, subtitle, date;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgThumbnail);
            title = itemView.findViewById(R.id.tvTitle);
            subtitle = itemView.findViewById(R.id.tvSubtitle);
            date = itemView.findViewById(R.id.tvDate);
        }
    }
}
