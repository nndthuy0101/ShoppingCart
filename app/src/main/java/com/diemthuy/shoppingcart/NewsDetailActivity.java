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

    private TextView titleDetailNews, txtdescriptionNews, txtDateNews;
    private ImageView imgNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        titleDetailNews = findViewById(R.id.titleDetailNews);
        txtdescriptionNews = findViewById(R.id.txtdescriptionNews);
        txtDateNews = findViewById(R.id.txtDateNews);
        imgNews = findViewById(R.id.imgNews);

        List<NewsDetailItem> newsList = NewsData.getSampleNews();
        if (!newsList.isEmpty()) {
            NewsDetailItem firstNews = newsList.get(0);

            titleDetailNews.setText(firstNews.getTitle());
            txtdescriptionNews.setText(firstNews.getDescription());
            txtDateNews.setText(firstNews.getDate());

            Glide.with(this)
                    .load(firstNews.getImage())
                    .into(imgNews);
        }
    }
}