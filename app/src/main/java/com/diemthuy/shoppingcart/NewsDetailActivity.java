package com.diemthuy.shoppingcart;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.diemthuy.shoppingcart.data.NewsData;
import com.diemthuy.shoppingcart.models.NewsDetailItem;

import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {

    private TextView titleTextView, descriptionTextView, dateTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail); // Đảm bảo layout tên là activity_main.xml

        // Ánh xạ view
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        dateTextView = findViewById(R.id.dateTextView);
        imageView = findViewById(R.id.imageView);

        // Lấy dữ liệu từ NewsItem1
        List<NewsDetailItem> newsList = NewsData.getSampleNews();
        if (!newsList.isEmpty()) {
            NewsDetailItem firstNews = newsList.get(0);

            titleTextView.setText(firstNews.getTitle());
            descriptionTextView.setText(firstNews.getDescription());
            dateTextView.setText(firstNews.getDate());

            Glide.with(this)
                    .load(firstNews.getImageUrl())
                    .into(imageView);
        }
    }
}