
package com.diemthuy.shoppingcart.models;

public class NewsDetailItem {
    private String title;
    private String description;
    private String date;
    private String imageUrl;

    // Constructor
    public NewsDetailItem(String title, String description, String date, String imageUrl) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

