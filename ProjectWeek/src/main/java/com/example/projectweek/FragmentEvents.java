package com.example.projectweek;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ((MainActivity)getActivity()).addFragment(new FragmentQuestionnaire());
    }

}