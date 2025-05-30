// CheckoutActivity.java
package com.diemthuy.shoppingcart;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.adapter.CartAdapter;
import com.diemthuy.shoppingcart.data.CartData;
import com.google.android.material.button.MaterialButton;

public class CheckOutActivity extends AppCompatActivity {
    TextView txtTotal, txtName, txtAddress, txtPhone, txtCardInfo;
    CartData cartData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        cartData = new CartData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_checkout);
        txtTotal = findViewById(R.id.txt_total_checkout);
        txtName = findViewById(R.id.txt_user_name);
        txtAddress = findViewById(R.id.txt_user_address);
        txtPhone = findViewById(R.id.txt_user_phone);
        txtCardInfo = findViewById(R.id.txt_user_card);

        // Mock user info
        txtName.setText("Giang Bao Tran");
        txtAddress.setText("Tower B, Sky Garden 2, District 7, HCM City");
        txtPhone.setText("0101819898");
        txtCardInfo.setText("Master Card ending ••••89");

        MaterialButton btnCheckout = findViewById(R.id.btn_checkout_action);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartAdapter(cartData.getItems(), this::updateTotal));

        updateTotal();

        btnCheckout.setOnClickListener(v -> {
            Toast.makeText(this, "Checked out: " + format(cartData.getTotal()), Toast.LENGTH_SHORT).show();
        });
    }

    private void updateTotal() {
        txtTotal.setText(format(cartData.getTotal()));
    }

    private String format(int amount) {
        return String.format("%,d", amount).replace(',', '.');
    }
}
