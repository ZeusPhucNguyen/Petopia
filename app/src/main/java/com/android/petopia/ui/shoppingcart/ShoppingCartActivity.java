package com.android.petopia.ui.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.petopia.ShippingCheckOutActivity;
import com.android.petopia.R;
import com.android.petopia.adapter.CartAdapter;
import com.android.petopia.event.MessageEvent;
import com.android.petopia.model.Cart;
import com.android.petopia.ui.service.product.PetShopActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    List<Cart> listCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        initView();
        Button btnBackShop = (Button) findViewById(R.id.btnBackShop);
        btnBackShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, PetShopActivity.class);
                startActivity(intent);
            }
        });
        Button btnShipping = (Button) findViewById(R.id.btnShipping);
        btnShipping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, ShippingCheckOutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        RecyclerView rvShoppingCart = findViewById(R.id.rvShoppingCart);

        initData();

        CartAdapter adapter = new CartAdapter(this, listCart);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvShoppingCart.setLayoutManager(layoutManager);
        rvShoppingCart.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            Cart cart = new Cart("Product" + i, "$100", "1" + i, "$1000", "All",
                    "https://kyluc.vn/Userfiles/Upload/images/Download/2020/6/5/fec34439cbca44a28b4969b14a593722.jpg");
            listCart.add(cart);
        }
    }
    /*@Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void goToDetail(Cart cart) {
        Intent intent = new Intent(this, ShippingCheckOutActivity.class);
        intent.putExtra("CHECKOUT", cart);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent.CartEvent cartEvent) {
        Cart cart = cartEvent.getCart();
        Log.d("TAG", "onMessageEvent: " + cart.getProName());
        goToDetail(cart);
    }*/
}