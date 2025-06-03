package com.diemthuy.shoppingcart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login); // Ensure your layout is correct


        // Apply edge-to-edge system bar handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Show the popup when the activity starts
        showSuccessPopup();
    }


    private void showSuccessPopup() {
        // Inflate the custom popup layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.payment_success_popup, null);


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();


        // Close button
        ImageView ivClose = dialogView.findViewById(R.id.imgClose);
        ivClose.setOnClickListener(v -> dialog.dismiss());


        // Button: Remind me
        MaterialButton btnRemindMe = dialogView.findViewById(R.id.btnPaymentSuccessfulBackShop);
        btnRemindMe.setOnClickListener(v -> {
            Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
    }
}

