package com.ahmadmuzaki.myrecyclerview.halamandetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmadmuzaki.myrecyclerview.R;

public class AhmadDahlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmad_dahlan);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Ahmad Dahlan");
        }
    }
}