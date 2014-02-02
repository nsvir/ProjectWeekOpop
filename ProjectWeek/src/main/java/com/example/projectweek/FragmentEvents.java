package com.example.projectweek;


import android.app.ActionBar;
import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentEvents extends ListFragment {

    private ArrayList<String> mArray = new ArrayList<String>();
    private String mColor = null;


    @Override
    public void onResume() {
        super.onResume();
        mArray.clear();

        for (int i = 0; i < 10; i++)
            mArray.add("Event " + i);

        setListAdapter(new MyArray());

        ActionBar actionBar = getActivity().getActionBar();

        if (mColor != null && actionBar != null) {
            getListView().setDivider(new ColorDrawable(Color.parseColor(mColor)));
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(mColor)));
        }
        getListView().setDividerHeight(2);
        getListView().setBackgroundColor(getResources().getColor(R.color.background));
    }


    public void setColor(String color) {
        mColor = color;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), AvisActivity.class);
        String message = mColor;
        intent.putExtra(MyActivity.EXTRA_MESSAGE, message);
        String title = mArray.get(position);
        intent.putExtra(MyActivity.EXTRA_TITLE, title);
        startActivity(intent);
    }

    public class MyArray extends ArrayAdapter<String> {

        public MyArray() {
            super(getActivity(), R.layout.item_event, mArray);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if (view == null)
                view = getActivity().getLayoutInflater().inflate(R.layout.item_event, parent, false);

            if (view != null) {
                ((TextView) view.findViewById(R.id.text)).setText(mArray.get(position));
            }

            return view;
        }
    }

}