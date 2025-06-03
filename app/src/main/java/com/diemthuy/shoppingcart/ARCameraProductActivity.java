package com.diemthuy.shoppingcart;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.diemthuy.shoppingcart.adapter.ProductARAdapter;
import com.diemthuy.shoppingcart.data.ProductData;
import com.diemthuy.shoppingcart.models.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ARCameraProductActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcamera_product);

        recyclerViewProductAR = findViewById(R.id.recyclerViewProductAR);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductAR.setLayoutManager(layoutManager);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewProductAR);

        // Lấy danh sách sản phẩm từ ProductData
        List<ProductItem> productList = ProductData.getEarringList();

        // Truyền vào adapter
        ProductARAdapter adapter = new ProductARAdapter(productList, this);
        recyclerViewProductAR.setAdapter(adapter);
    }
}