package com.example.projectweek;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class ConnexionActivity extends MyActivity {

    FragmentConnexion fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new FragmentConnexion();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void finishMe() {

    }

    @Override
    public void onBackPressed() {
        Intent resultData = new Intent();
        resultData.putExtra(MyActivity.EXTRA_MESSAGE, "close");
        setResult(0, resultData);
        finish();
    }
}
