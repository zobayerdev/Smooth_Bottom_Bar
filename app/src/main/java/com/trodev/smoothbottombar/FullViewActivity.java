package com.trodev.smoothbottombar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullViewActivity extends AppCompatActivity {

    TextView nameTv, detailsTv;
    ImageView imageIv;
    String name, details , image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        /*init views*/
        nameTv = findViewById(R.id.name);
        detailsTv = findViewById(R.id.details);
        imageIv = findViewById(R.id.image);

        /*get data from custom adapter*/
        name = getIntent().getStringExtra("name");
        details = getIntent().getStringExtra("details");
        image = getIntent().getStringExtra("img");

        /*get image on json data*/
        Glide
                .with(FullViewActivity.this)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(imageIv);

        /*set data on views*/
        nameTv.setText(name);
        detailsTv.setText(details);
    }
}