package com.trodev.smoothbottombar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullDataActivity extends AppCompatActivity {

    TextView nameTv, descriptionTv, dateTv;
    ImageView imageIv;
    String name, des, date , image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_data);

        /*init views*/
        nameTv = findViewById(R.id.name);
        descriptionTv = findViewById(R.id.description);
        dateTv = findViewById(R.id.date);
        imageIv = findViewById(R.id.image);

        /*get data from custom adapter*/
        name = getIntent().getStringExtra("name");
        des = getIntent().getStringExtra("des");
        date = getIntent().getStringExtra("date");
        image = getIntent().getStringExtra("img");

        /*get image on json data*/
        Glide
                .with(FullDataActivity.this)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(imageIv);

        /*set data on views*/
        nameTv.setText(name);
        descriptionTv.setText(des);
        dateTv.setText(date);

    }
}