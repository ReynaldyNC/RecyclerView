package com.reynaldynurcahyo.projectrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private String title = "Detail";

    ImageView ivImage;
    TextView tvDesc, tvCreator, tvRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle(title);

        ivImage = findViewById(R.id.item_image);
        tvDesc = findViewById(R.id.item_desc);
        tvCreator = findViewById(R.id.item_creator);
        tvRelease = findViewById(R.id.item_release);

        getIntentData();
    }

    private void getIntentData() {
        int intImage = getIntent().getIntExtra("item_image", 0);
        String intName = getIntent().getStringExtra("item_name");
        String intDesc = getIntent().getStringExtra("item_desc");
        String intCreator = getIntent().getStringExtra("item_creator");
        String intRelease = getIntent().getStringExtra("item_release");

        setIntentData(intImage, intName, intDesc, intCreator, intRelease);
        setActionBarTitle(intName);
    }

    private void setIntentData(int intImage, String intName, String intDesc, String intCreator, String intRelease) {
        Glide.with(this)
                .asBitmap()
                .load(intImage)
                .into(ivImage);
        tvDesc.setText(intDesc);
        tvCreator.setText(intCreator);
        tvRelease.setText(intRelease);
    }

    private void setActionBarTitle(String intName) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(intName);
        }
    }
}