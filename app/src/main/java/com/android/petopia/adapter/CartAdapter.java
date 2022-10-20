package com.android.petopia.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.petopia.R;
import com.android.petopia.model.Cart;
import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Cart> listCart;

    public CartAdapter(Activity activity, List<Cart> listCart) {
        this.activity = activity;
        this.listCart = listCart;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_shopping_cart, parent, false);
        CartHolder holder = new CartHolder(itemView);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CartHolder vh = (CartHolder) holder;
        Cart model = listCart.get(position);
        vh.tvName.setText(model.getProName());
        vh.tvType.setText(model.getProType());
        vh.tvPrice.setText(model.getProPrice());
        vh.tvQty.setText(model.getQty());
        Glide.with(activity).load(model.getProThumbnail()).into(vh.ivCover);
    }

    @Override
    public int getItemCount() {
        return listCart.size();
    }
    public class CartHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvType, tvQty, tvPrice, tvTotal;
        ImageView ivCover;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvType = itemView.findViewById(R.id.tvType);
            tvQty = itemView.findViewById(R.id.tvQty);
            tvTotal = itemView.findViewById(R.id.tvTotal);
        }
    }

}
