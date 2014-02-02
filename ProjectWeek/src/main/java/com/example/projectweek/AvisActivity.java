package com.example.projectweek;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

/**
 * Created by svirch_n on 31/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class AvisActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ActionBar actionBar = getActionBar();
        String color = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        if (actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));
        setTitle(intent.getStringExtra(MyActivity.EXTRA_TITLE));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FragmentAvis())
                    .commit();
        }
    }
}
