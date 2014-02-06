package com.example.projectweek;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class EventActivity extends MyActivity {

    FragmentEvents fragmentEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
        }

        fragmentEvents = new FragmentEvents();

        Intent intent = getIntent();
        fragmentEvents.setColor(intent.getStringExtra(MyActivity.EXTRA_MESSAGE));
        fragmentEvents.setEvent(intent.getStringArrayExtra(MyActivity.EXTRA_EVENT));
        setTitle(intent.getStringExtra(MyActivity.EXTRA_TITLE));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentEvents)
                    .commit();
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar, menu);
        MenuItem item = menu.findItem(R.id.default_search);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (item != null)
            searchView = (SearchView) item.getActionView();
        if (searchView != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.default_search:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
