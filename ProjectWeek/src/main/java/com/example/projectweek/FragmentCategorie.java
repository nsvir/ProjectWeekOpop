package com.example.projectweek;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentCategorie extends ListFragment {

    private Typeface mTypeface = null;

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
            "RESTAURANT",
            "HOTEL",
            "MODE",
            "SERVICE",
            "CULTUREL",
            "SORTIE",
            "ELECTRONIQUE"
    };

    @Override
    public void onResume() {
        super.onResume();

        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        setListAdapter(new MyAdapter());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), EventActivity.class);
        String message = mColor[position];
        intent.putExtra(MyActivity.EXTRA_MESSAGE, message);
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
                ((TextView) view.findViewById(R.id.text)).setTypeface(mTypeface);
                view.findViewById(R.id.linear).setBackgroundColor(Color.parseColor(mColor[position]));
            }
            return view;
        }
    }

}