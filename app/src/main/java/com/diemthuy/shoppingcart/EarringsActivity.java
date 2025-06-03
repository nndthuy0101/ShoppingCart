package com.diemthuy.shoppingcart;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.adapter.LastCollectionAdapter;
import com.diemthuy.shoppingcart.data.LastCollectionData;
import androidx.recyclerview.widget.GridLayoutManager;
import com.diemthuy.shoppingcart.adapter.ProductAdapter;
import com.diemthuy.shoppingcart.data.ProductData;
import com.diemthuy.shoppingcart.models.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class EarringsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_earrings);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lấy danh sách sản phẩm từ lớp ProductData
        List<ProductItem> earringList = ProductData.getEarringList();

        // Khởi tạo RecyclerView
        RecyclerView earringsRecyclerView = findViewById(R.id.recyclerViewEarrings);
        earringsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ProductAdapter adapter = new ProductAdapter(earringList);
        earringsRecyclerView.setAdapter(adapter);
    }

}