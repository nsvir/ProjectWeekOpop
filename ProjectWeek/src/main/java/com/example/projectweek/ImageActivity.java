package com.example.projectweek;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Nicolas on 2/7/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class ImageActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        Intent intent = getIntent();
        ActionBar actionBar = getActionBar();
        String mColor = intent.getStringExtra(MyActivity.EXTRA_EVENT);

        if (actionBar != null && mColor != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(mColor)));
        setTitle("RODOLPHA_04");

        if (imageView != null) {
            imageView.setBackgroundColor(getResources().getColor(R.color.background));
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.photo_avis));
        }

    }
}
