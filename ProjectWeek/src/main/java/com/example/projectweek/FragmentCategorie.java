package com.example.projectweek;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentCategorie extends Fragment implements View.OnClickListener {

    private Typeface mTypeface = null;

    private int[] mColor = {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
            R.color.color7
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        View view = inflater.inflate(R.layout.fragment_categorie, container, false);
        View newView;
        ViewGroup viewGroup;
        if (view != null) {
            viewGroup = (ViewGroup) view.findViewById(R.id.linear);
            for (int i = 0; i < mArray.length; i++) {
                newView = inflater.inflate(R.layout.item_categorie, null);
                ((TextView) newView.findViewById(R.id.text)).setText(mArray[i]);
                ((TextView) newView.findViewById(R.id.text)).setTypeface(mTypeface);
                newView.setBackgroundColor(getResources().getColor(mColor[i]));
                newView.setOnClickListener(this);
                viewGroup.addView(newView, param);
            }

        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), EventActivity.class);
        String message = getActivity().getResources().getString(mColor[((ViewGroup) view.getParent()).indexOfChild(view)]);
        intent.putExtra(MyActivity.EXTRA_MESSAGE, message);
        String title = mArray[((ViewGroup) view.getParent()).indexOfChild(view)];
        intent.putExtra(MyActivity.EXTRA_TITLE, title);
        startActivity(intent);
    }
}