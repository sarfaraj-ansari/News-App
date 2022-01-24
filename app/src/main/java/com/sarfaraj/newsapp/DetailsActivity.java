package com.sarfaraj.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.sarfaraj.newsapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String articleLink=getIntent().getStringExtra("article_link");
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(articleLink));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        String imageUrl=getIntent().getStringExtra("imageUrl");
        String desc=getIntent().getStringExtra("desc");
        String title=getIntent().getStringExtra("title");


        Glide.with(this).load(imageUrl).into(binding.imageView);
        binding.descTextView.setText(desc);
        binding.titleTextView.setText(title);
    }
}