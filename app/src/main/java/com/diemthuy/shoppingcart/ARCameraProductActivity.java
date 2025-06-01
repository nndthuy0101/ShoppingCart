package com.diemthuy.shoppingcart;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.adapter.ProductARAdapter;
import com.diemthuy.shoppingcart.data.ProductData;
import com.diemthuy.shoppingcart.models.ProductItem;

import java.util.List;

public class ARCameraProductActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductAR;
    private ProductARAdapter productARAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_arcamera_product);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupProductList();
    }

    private void setupProductList() {
        recyclerViewProductAR = findViewById(R.id.recyclerViewProductAR);
        recyclerViewProductAR.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<ProductItem> productList = ProductData.getEarringList();
        productARAdapter = new ProductARAdapter(productList);
        recyclerViewProductAR.setAdapter(productARAdapter);
    }
}
