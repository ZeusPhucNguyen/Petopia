package com.android.petopia.ui.service.product;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.petopia.R;
import com.android.petopia.adapter.ProductAdapter;
import com.android.petopia.event.MessageEvent;
import com.android.petopia.model.Product;
import com.android.petopia.ui.shoppingcart.ShoppingCartActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class PetShopActivity extends AppCompatActivity {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.banner_petshop_1,
            R.drawable.banner_petshop_2,
            R.drawable.banner_petshop_3};

    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_shop);
        initBanner();
        initView();

        ImageButton ibtCart = (ImageButton) findViewById(R.id.ibtCart);
        ibtCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PetShopActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        RecyclerView rvShop = findViewById(R.id.rvShop);
        //B1 data
        initData();

        //B2 Adapter
        ProductAdapter adapter = new ProductAdapter(this, listProduct);

        //B3 Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        //B4 RecycleView
        rvShop.setLayoutManager(layoutManager);
        rvShop.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product(1 + i,
                    "Product hehehe" + i,
                    "All" + i,
                    "@100" + 10 * i,
                    "https://kyluc.vn/Userfiles/Upload/images/Download/2020/6/5/fec34439cbca44a28b4969b14a593722.jpg",
                    "Originating from the United Kingdom," +
                            " featuring a beautiful and soft long coat that looks quite like a Japanese poodle." +
                            " The British Longhair cat is considered a beautiful and beautiful ornamental" +
                            " cat with a large round head and wide cheeks that will make you unable to ignore it.");
            listProduct.add(product);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void goToDetail(Product product) {
        Intent intent = new Intent(this, DetailProductActivity.class);
        intent.putExtra("PRODUCT", product);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent.ProductEvent productEvent) {
        Product product = productEvent.getProduct();
        Log.d("TAG", "onMessageEvent: " + product.getName());
        goToDetail(product);
    }

    private void initBanner() {
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("TAG", "onClick: " + position);
            }
        });
    }
}