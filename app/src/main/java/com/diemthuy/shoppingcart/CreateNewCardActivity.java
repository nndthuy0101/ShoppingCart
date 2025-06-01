package com.diemthuy.shoppingcart;


import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;


import com.diemthuy.shoppingcart.adapter.ViewPaperAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class CreateNewCardActivity extends AppCompatActivity {


    private ViewPager2 viewPagerCards;
    private DotsIndicator dotsIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_card);


        viewPagerCards = findViewById(R.id.viewPagerCards);
        dotsIndicator = findViewById(R.id.dots_indicator);


        int[] imageResIds = {
                R.mipmap.visa_logo,
                R.mipmap.mastercard_logo,
                R.mipmap.momo_logo
        };


        ViewPaperAdapter adapter = new ViewPaperAdapter(this, imageResIds);
        viewPagerCards.setAdapter(adapter);
        dotsIndicator.setViewPager2(viewPagerCards);
    }
}

