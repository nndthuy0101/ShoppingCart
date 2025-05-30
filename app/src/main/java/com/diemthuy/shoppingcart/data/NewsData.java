package com.diemthuy.shoppingcart.data;

import com.diemthuy.shoppingcart.models.NewsDetailItem;
import java.util.ArrayList;
import java.util.List;

public class NewsData {

    public static List<NewsDetailItem> getSampleNews() {
        List<NewsDetailItem> list = new ArrayList<>();

        list.add(new NewsDetailItem(
                "Pocket These Quick Tips for Cleaning Your Ear Piercings",
                "You guys know how much I love mixing high and low-end – it’s the best way to get the most bang for your buck while still elevating your wardrobe...",
                "February 22, 2025",
                "https://your-image-url.com/image.jpg"
        ));

        // Bạn có thể thêm nhiều dữ liệu nữa nếu muốn
        return list;
    }
}