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
            ((HeaderViewHolder) holder).headerNotification.setText(item.getTitle());
        } else if (holder instanceof NotificationViewHolder) {
            ((NotificationViewHolder) holder).txtNotification.setText(item.getTitle());
            ((NotificationViewHolder) holder).txtNotificationMessage.setText(item.getMessage());
            ((NotificationViewHolder) holder).txtNotificationTime.setText(item.getTime());
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerNotification;

        HeaderViewHolder(View itemView) {
            super(itemView);
            headerNotification = itemView.findViewById(R.id.headerNotification);
        }
    }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView txtNotification, txtNotificationMessage, txtNotificationTime;

        NotificationViewHolder(View itemView) {
            super(itemView);
            txtNotification = itemView.findViewById(R.id.txtNotification);
            txtNotificationMessage = itemView.findViewById(R.id.txtNotificationMessage);
            txtNotificationTime = itemView.findViewById(R.id.txtNotificationTime);
        }
    }
}
