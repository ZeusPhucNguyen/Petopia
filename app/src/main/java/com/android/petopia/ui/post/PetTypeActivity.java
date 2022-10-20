package com.android.petopia.ui.post;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.android.petopia.R;

public class PetTypeActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton rb_1,rb_2,rb_3,rb_4,rb_5;

    String petType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_type);
        rb_1 = findViewById(R.id.rb_1);
        rb_2 = findViewById(R.id.rb_2);
        rb_3 = findViewById(R.id.rb_3);
        rb_4 = findViewById(R.id.rb_4);
        rb_5 = findViewById(R.id.rb_5);
        rb_1.setOnClickListener(this);
        rb_2.setOnClickListener(this);
        rb_3.setOnClickListener(this);
        rb_4.setOnClickListener(this);
        rb_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_1:
                toPetAdoption();
                break;
            case R.id.rb_2:
                toPetAdoption();
                break;
            case R.id.rb_3:
                toPetAdoption();
                break;
            case R.id.rb_4:
                toPetAdoption();
                break;
            case R.id.rb_5:
                toPetAdoption();
                break;

            default:
                break;
        }
    }

    private void toPetAdoption() {
        getText();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("PetType", petType);
        Log.d("TAG", "put: " + petType);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    private void getText() {
        if (rb_1.isChecked()){
            petType = rb_1.getText().toString();
        }else if (rb_2.isChecked()){
            petType = rb_2.getText().toString();
        }else if (rb_3.isChecked()){
            petType = rb_3.getText().toString();
        }else if (rb_4.isChecked()){
            petType = rb_4.getText().toString();
        }else if (rb_5.isChecked()){
            petType = rb_5.getText().toString();
        }
    }
}