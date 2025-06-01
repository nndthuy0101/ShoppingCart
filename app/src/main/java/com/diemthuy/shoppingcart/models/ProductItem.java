package com.diemthuy.shoppingcart.models;

public class ProductItem {
        public String title;
        public String price;
        public int imageRes;
        public String rating;

        public ProductItem(String title, String price, int imageRes, String rating) {
            this.title = title;
            this.price = price;
            this.imageRes = imageRes;
            this.rating = rating;
        }
    }


