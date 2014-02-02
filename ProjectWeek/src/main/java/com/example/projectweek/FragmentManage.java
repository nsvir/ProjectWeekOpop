package com.example.projectweek;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by svirch_n on 31/01/14.
 * nicolas.svirchevsky@epitech.eu
 */

public class FragmentManage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_manage, container, false);

        if (view == null)
            return null;
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.account).setOnClickListener(this);

        Typeface mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");

        ((TextView) view.findViewById(R.id.text1)).setTypeface(mTypeface);
        ((TextView) view.findViewById(R.id.text2)).setTypeface(mTypeface);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(getActivity(), QuestionnaireActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(getActivity(), CategorieActivity.class));
                break;
            case R.id.account:
                Intent intent = new Intent(getActivity(), AccountActivity.class);
                startActivity(intent);
                break;
        }
    }
}