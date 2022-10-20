package com.android.petopia.ui.service.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.petopia.R;
import com.android.petopia.model.Product;
import com.bumptech.glide.Glide;

public class DetailProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        Product product = (Product) getIntent().getSerializableExtra("PRODUCT");
        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvType = (TextView) findViewById(R.id.tvType);
        TextView tvPrice = (TextView) findViewById(R.id.tvPrice);
        ImageView ivCover = (ImageView) findViewById(R.id.ivCover);
        TextView tvDes = (TextView) findViewById(R.id.tvDes);
        tvName.setText(product.getName());
        tvType.setText(product.getType());
        tvPrice.setText(product.getPrice());
        tvDes.setText(product.getDescription());
        Glide.with(this).load(product.getThumbnail()).into(ivCover);
        Button btnBackShop = (Button) findViewById(R.id.btnBackShop);
        btnBackShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailProductActivity.this, PetShopActivity.class);
                startActivity(intent);
            }
        });

    }
}