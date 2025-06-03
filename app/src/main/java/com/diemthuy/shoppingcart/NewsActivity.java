package com.diemthuy.shoppingcart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.diemthuy.shoppingcart.adapter.NewsAdapter;
import com.diemthuy.shoppingcart.models.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerViewNews = findViewById(R.id.recyclerViewNews);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this));

        List<NewsItem> dummyData = new ArrayList<>();
        dummyData.add(new NewsItem(
                "Pocket These Quick Tips for Cleaning Your Ear Piercings Without Worrying About Bumps",
                "Are you passionate about ear piercings but afraid of infection or pus?",
                "August 22, 2025",
                R.mipmap.img_sample));
        dummyData.add(new NewsItem(
                "Pocket These Quick Tips for Cleaning Your Ear Piercings Without Worrying About Bumps",
                "Are you passionate about ear piercings but afraid of infection or pus?",
                "August 22, 2025",
                R.mipmap.img_sample));
        dummyData.add(new NewsItem(
                "Pocket These Quick Tips for Cleaning Your Ear Piercings Without Worrying About Bumps",
                "Are you passionate about ear piercings but afraid of infection or pus?",
                "August 22, 2025",
                R.mipmap.img_sample));
        NewsAdapter adapter = new NewsAdapter(dummyData);
        recyclerViewNews.setAdapter(adapter);
    }
}
