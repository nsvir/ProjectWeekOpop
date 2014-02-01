package com.example.projectweek;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class MyActivity extends ActionBarActivity{

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_TITLE = "com.example.myfirstapp.TITLE";

    public void logout() {
        SharedPreferences sp = getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();

        Ed.putString("login", null);
        Ed.putString("password", null);
        Ed.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

    @Override
    public void setTitle(CharSequence title) {

        SpannableString s = new SpannableString(title);
        s.setSpan(new TypefaceSpan("Roboto-Bold.ttf"), 0, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        getActionBar().setTitle(s);
    }
}
