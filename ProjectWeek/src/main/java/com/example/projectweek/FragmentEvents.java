package com.example.projectweek;


import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentEvents extends ListFragment {

    private ArrayList<String> mArray = new ArrayList<String>();

    @Override
    public void onResume() {
        super.onResume();
        mArray.clear();

        for (int i = 0; i < 10; i++)
            mArray.add("Event " + i);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mArray));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_bar, menu);
        MenuItem item = menu.findItem(R.id.default_search);

        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (item != null)
            searchView = (SearchView) item.getActionView();
        if (searchView != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.default_search:
                return true;
            case android.R.id.home:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ((MainActivity) getActivity()).addFragment(new FragmentQuestionnaire());
    }

}