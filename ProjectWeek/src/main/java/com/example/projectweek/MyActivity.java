package com.example.projectweek;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class MyActivity extends ActionBarActivity{

    public void logout() {
        SharedPreferences sp = getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();

        Ed.putString("login", null);
        Ed.putString("password", null);
        Ed.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
