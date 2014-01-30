package com.example.projectweek;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentCategorie extends ListFragment {

    private String[] mColor = {
            "#F8B194",
            "#EF997B",
            "#F67281",
            "#C16E87",
            "#706684",
            "#73587D",
            "#355C7C"
    };


    private String[] mArray = {
            "Restaurant",
            "Hotel",
            "Mode",
            "Service",
            "Culturel",
            "Sortie",
            "Electronique"
    };

    @Override
    public void onResume() {
        super.onResume();

        setListAdapter(new MyAdapter());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), EventActivity.class);
        startActivity(intent);
    }

    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter() {
            super(getActivity(), R.layout.item_categorie, mArray);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            if (view == null)
                view = getActivity().getLayoutInflater().inflate(R.layout.item_categorie, null);
            if (view != null) {
                ((TextView) view.findViewById(R.id.text)).setText(mArray[position]);
                view.findViewById(R.id.linear).setBackgroundColor(Color.parseColor(mColor[position]));
            }
            return view;
        }
    }

}