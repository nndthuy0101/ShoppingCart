package com.diemthuy.shoppingcart;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.adapter.NotificationAdapter;
import com.diemthuy.shoppingcart.models.NotificationItem;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    NotificationAdapter adapter;
    List<NotificationItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView = findViewById(R.id.notificationRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();

        // Add header "Latest"
        itemList.add(new NotificationItem(NotificationItem.TYPE_HEADER, "Latest", "", ""));
        // Add notifications
        itemList.add(new NotificationItem(NotificationItem.TYPE_NOTIFICATION, "Order Successfully!", "Your order is confirmed.", "30 minutes ago"));

        // Add header "Older"
        itemList.add(new NotificationItem(NotificationItem.TYPE_HEADER, "Older", "", ""));
        // Add older notifications
        itemList.add(new NotificationItem(NotificationItem.TYPE_NOTIFICATION, "Freeshipping", "Special offer from June 1st to June 30th", "2 days ago"));

        adapter = new NotificationAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}
