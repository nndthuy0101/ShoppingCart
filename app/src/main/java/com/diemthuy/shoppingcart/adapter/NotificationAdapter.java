package com.diemthuy.shoppingcart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.NotificationItem;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NotificationItem> notificationList;

    public NotificationAdapter(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public int getItemViewType(int position) {
        return notificationList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NotificationItem.TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_notification, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
            return new NotificationViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NotificationItem item = notificationList.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerTextView.setText(item.getTitle());
        } else if (holder instanceof NotificationViewHolder) {
            ((NotificationViewHolder) holder).titleTextView.setText(item.getTitle());
            ((NotificationViewHolder) holder).messageTextView.setText(item.getMessage());
            ((NotificationViewHolder) holder).timeTextView.setText(item.getTime());
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTextView;

        HeaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.headerTextView);
        }
    }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, messageTextView, timeTextView;

        NotificationViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }
}
