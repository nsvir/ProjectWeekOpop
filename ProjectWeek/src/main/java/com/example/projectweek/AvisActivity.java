package com.example.projectweek;

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

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FragmentAvis())
                    .commit();
        }
    }
}
