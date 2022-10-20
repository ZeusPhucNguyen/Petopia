package com.android.petopia.ui.post;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.petopia.R;
import com.android.petopia.adapter.PetImageAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class PostPetAdoptActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int MY_REQUEST_CODE = 10;
    RelativeLayout rlPetType, rlPetImage;
    TextView tvPetType;
    ImageView ivPetImage;
    RecyclerView rvPetImage;
    ArrayList<Uri> uris = new ArrayList<>();
    PetImageAdapter adapter;

    private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data.getClipData() != null) {
                            int x = data.getClipData().getItemCount();
                            for (int i = 0; i < x; i++) {
                                Uri uri = data.getClipData().getItemAt(i).getUri();
                                uris.add(uri);
                            }
                            adapter.notifyDataSetChanged();
                        }else {
                            Uri uri = data.getData();
                            uris.add(uri);
                        }
                        adapter.notifyDataSetChanged();

                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pet_adopt);
        initUi();

        adapter = new PetImageAdapter(this, uris, getApplicationContext());
        rvPetImage.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rvPetImage.setAdapter(adapter);
    }

    private void initUi() {
        rlPetType = findViewById(R.id.rlPetType);
        tvPetType = findViewById(R.id.tvPetType);
        rlPetImage = findViewById(R.id.rlPetImage);
        ivPetImage = findViewById(R.id.ivPetImage);
        rvPetImage = findViewById(R.id.rvPetImage);
        rlPetImage.setOnClickListener(this);
        rlPetType.setOnClickListener(this);
    }

    private void checkPetType() {
        String petType = getIntent().getStringExtra("PetType");
        Log.d("TAG", "get: " + petType);
        if (petType == null) {
            tvPetType.setText("Select one");
        } else {
            tvPetType.setText(petType);
        }

    }

    @Override
    protected void onResume() {
        checkPetType();
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlPetType:
                toPetType();
                break;

            case R.id.rlPetImage:
                addImage();
                break;

            default:
                break;
        }
    }

    private void addImage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            openImage();
            return;
        }
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openImage();
        } else {
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openImage();
            }
        }
    }

    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent, "Select Image"));
    }

    private void toPetType() {
        startActivity(new Intent(this, PetTypeActivity.class));
    }
}