package com.diemthuy.shoppingcart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.adapter.CartAdapter;
import com.diemthuy.shoppingcart.data.CartData;

public class ShoppingCartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView txtSubtotal, txtDelivery, txtDiscount, txtTotal;
    CartData cartData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart); // điều chỉnh chỗ này cho [hù hợp với activity hiện tại thì mới chạy đc nha

        cartData = new CartData();
        recyclerView = findViewById(R.id.recyclerView);
        txtSubtotal = findViewById(R.id.summary_subtotal);
        txtDelivery = findViewById(R.id.summary_delivery);
        txtDiscount = findViewById(R.id.summary_discount);
        txtTotal = findViewById(R.id.summary_total);

        EditText editPromo = findViewById(R.id.editPromo);
        Button btnApply = findViewById(R.id.btnApply);
        Button btnCheckout = findViewById(R.id.btnCheckout);

        CartAdapter adapter = new CartAdapter(cartData.getItems(), this::updateSummary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        updateSummary();

        btnApply.setOnClickListener(v -> {
            String code = editPromo.getText().toString().trim();
            if (code.equalsIgnoreCase("SALE10")) {
                cartData.setDiscount(100000);
                Toast.makeText(this, "Applied 100.000 discount", Toast.LENGTH_SHORT).show();
            } else {
                cartData.setDiscount(0);
                Toast.makeText(this, "Invalid promo", Toast.LENGTH_SHORT).show();
            }
            updateSummary();
        });

        btnCheckout.setOnClickListener(v -> {
            Toast.makeText(this, "Total: " + format(cartData.getTotal()), Toast.LENGTH_SHORT).show();
        });
    }

    private void updateSummary() {
        txtSubtotal.setText(format(cartData.getSubTotal()));
        txtDelivery.setText(format(cartData.getDeliveryFee()));
        txtDiscount.setText(format(cartData.getDiscount()));
        txtTotal.setText(format(cartData.getTotal()));
    }

    private String format(int amount) {
        return String.format("%,d", amount).replace(',', '.');
    }
}
