package com.android.petopia.ui.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.petopia.R;
import com.android.petopia.adapter.ServiceAdapter;
import com.android.petopia.event.MessageEvent;
import com.android.petopia.model.Product;
import com.android.petopia.model.Service;
import com.android.petopia.ui.service.product.DetailProductActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class DetailVetsActivity extends AppCompatActivity {
    List<Service> listService = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vets);
        initview();
    }

    private void initview() {
        RecyclerView rvVets = findViewById(R.id.rvService_Vets);
        //B1 data
        initData();

        //B2 Adapter
        ServiceAdapter adapter = new ServiceAdapter(this,listService);

        //B3 Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        //B4 RecycleView
        rvVets.setLayoutManager(layoutManager);
        rvVets.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 10;i++){
            Service service = new Service(1 + i,
                    "Vets Doctor" +i,
                    "Ha Noi, Viet Nam",
                    "091829138" + i,
                    "phucnguyendev101" + i,
                    "Test thu xem des okela hay khong da roi co du lieu ra cho anh em xem sau nhe" + i,
                    "https://doctor4u.vn/wp-content/themes/Doctor4UElite/asset/images/bg-block-bacsi.png");
            listService.add(service);
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

    private void goToDetail(Service service) {
        Intent intent = new Intent(this, DetailServiceActivity.class);
        intent.putExtra("Service", service);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent.ServiceEvent serviceEvent) {
        Service service = serviceEvent.getService();
        Log.d("TAG", "onMessageEvent: " + service.getNameLocation());
        goToDetail(service);
    }
}