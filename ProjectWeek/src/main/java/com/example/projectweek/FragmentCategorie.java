package com.example.projectweek;


import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentCategorie extends ListFragment {

    private String[] mArray = {
            "Hotel",
            "Mode",
            "Service",
            "Culturel",
            "Sortie",
    };

    @Override
    public void onResume() {
        super.onResume();

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mArray));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), EventActivity.class);
        startActivity(intent);
    }

}