package com.android.petopia.ui.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.petopia.R;
import com.android.petopia.model.Pet;
import com.android.petopia.model.Product;
import com.android.petopia.ui.service.product.DetailProductActivity;
import com.android.petopia.ui.service.product.PetShopActivity;
import com.bumptech.glide.Glide;

public class DetailPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pet);

        Pet pet = (Pet) getIntent().getSerializableExtra("PET");
        TextView tvPetName = (TextView) findViewById(R.id.tvPetName);
        TextView tvLocation = (TextView) findViewById(R.id.tvLocation);
        TextView tvPetAge = (TextView) findViewById(R.id.tvPetAge);
        TextView tvPetSex = (TextView) findViewById(R.id.tvPetSex);
        TextView tvPetBreed = (TextView) findViewById(R.id.tvPetBreed);
        ImageView ivCover = (ImageView) findViewById(R.id.ivCover);
        TextView tvPetDes = (TextView) findViewById(R.id.tvPetDes);

        tvPetName.setText(pet.getName());
        tvLocation.setText(pet.getAddress());
        tvPetAge.setText(pet.getAge());
        tvPetSex.setText(pet.getSex());
        tvPetBreed.setText(pet.getBreed());
        tvPetDes.setText(pet.getDescription());
        Glide.with(this).load(pet.getThumbnail()).into(ivCover);
        Button btnBackShop = (Button) findViewById(R.id.btnBackShop);
        btnBackShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPetActivity.this, PetFragment.class);
                startActivity(intent);
            }
        });
    }
}