package com.example.projectweek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by svirch_n on 31/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class ManageActivity extends MyActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new FragmentManage();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}
