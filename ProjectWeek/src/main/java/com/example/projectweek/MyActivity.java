package com.example.projectweek;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_TITLE = "com.example.myfirstapp.TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void logout() {
        SharedPreferences sp = getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();

        Ed.putString("login", null);
        Ed.putString("password", null);
        Ed.commit();
        finish();
    }

    public boolean isConnected() {
        SharedPreferences spSignUp = getSharedPreferences("signUpInfo", 0);
        SharedPreferences spInfo = getSharedPreferences("loginInfo", 0);
        String signUpLogin = spSignUp.getString("login", null);
        String signUpPswd = spSignUp.getString("password", null);
        String currentLogin = spInfo.getString("login", null);
        String currentPswd = spInfo.getString("password", null);

        // Remember to fuse if null and delete equals("");
        if (currentLogin == null || currentPswd == null)
            return (false);
        if (currentLogin.equals("") && currentPswd.equals(""))
            return (true);
        if (signUpLogin == null || signUpPswd == null)
            return (false);
        if (signUpLogin.equals(currentLogin) == true && signUpPswd.equals(currentPswd) == true)
            return (true);
        return (false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
                break;
            case R.id.account:
                Intent intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (title != null) {
            ActionBar actionBar = getActionBar();
            SpannableString s = new SpannableString(title);
            s.setSpan(new TypefaceSpan("Roboto-Bold.ttf"), 0, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (actionBar != null)
                actionBar.setTitle(s);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isConnected())
            finishMe();
    }

    protected void finishMe() {
        finish();
    }
}
