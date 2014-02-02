package com.example.projectweek;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by svirch_n on 01/02/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentAccount extends Fragment {

    Typeface tp = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        tp = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        ((TextView) view.findViewById(R.id.profileEditTxt)).setTypeface(tp);
        ((TextView) view.findViewById(R.id.profileEditTxt)).setTypeface(tp);
        ((TextView) view.findViewById(R.id.profileEditTxt)).setTypeface(tp);
        ((TextView) view.findViewById(R.id.profileEditTxt)).setTypeface(tp);
        ((TextView) view.findViewById(R.id.profileEditTxt)).setTypeface(tp);

        return view;
    }
}
