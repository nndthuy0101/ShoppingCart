package com.diemthuy.shoppingcart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemthuy.shoppingcart.R;
import com.diemthuy.shoppingcart.models.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> cartList;
    private Runnable updateTotal;

    public CartAdapter(List<CartItem> cartList, Runnable updateTotal) {
        this.cartList = cartList;
        this.updateTotal = updateTotal;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, variant, price, quantity;
        ImageView btnPlus, btnMinus, image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            variant = itemView.findViewById(R.id.item_variant);
            price = itemView.findViewById(R.id.item_price);
            quantity = itemView.findViewById(R.id.item_quantity);
            btnPlus = itemView.findViewById(R.id.btn_plus);
            btnMinus = itemView.findViewById(R.id.btn_minus);
            image = itemView.findViewById(R.id.item_image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CartItem item = cartList.get(position);
        holder.name.setText(item.getName());
        holder.variant.setText(item.getVariant());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.price.setText(String.format("%,d", item.getTotalPrice()));
        holder.image.setImageResource(item.getImageResId());

        holder.btnPlus.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyItemChanged(position);
            updateTotal.run();
        });

        holder.btnMinus.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyItemChanged(position);
                updateTotal.run();
            }
        });
    }

    @Override
    public int getItemCount() { return cartList.size(); }
}