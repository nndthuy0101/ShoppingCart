package com.diemthuy.shoppingcart.data;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    public static List<ProductItem> getEarringList() {
        List<ProductItem> earringList = new ArrayList<>();
        earringList.add(new ProductItem("Tote Earrings Tote Earrings", "150.000 VND", R.mipmap.lastcollection1, "4.3"));
        earringList.add(new ProductItem("Tote Earrings", "150.000 VND", R.mipmap.lastcollection2, "4.3"));
        earringList.add(new ProductItem("Tote Earrings", "150.000 VND", R.mipmap.lastcollection1, "4.3"));
        earringList.add(new ProductItem("Tote Earrings", "150.000 VND", R.mipmap.lastcollection2, "4.3"));
        // Thêm các sản phẩm khác nếu cần
        return earringList;
    }
}

