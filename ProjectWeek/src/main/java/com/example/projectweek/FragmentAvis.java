package com.example.projectweek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by svirch_n on 31/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentAvis extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_avis, container, false);

        ViewGroup viewGroup = null;
        if (view != null)
            viewGroup = (ViewGroup) view.findViewById(R.id.container);

        View newView = inflater.inflate(R.layout.item_avis, null);

        if (viewGroup != null && newView != null)
        {
            ((TextView)newView.findViewById(R.id.title)).setText("1. Déçu");
            ((TextView)newView.findViewById(R.id.content)).setText("Le magasin est mal rangé. Les étalages sont éparpillés");
            ((ImageView)newView.findViewById(R.id.icone)).setImageDrawable(getResources().getDrawable(R.drawable.icone_sophie));
            viewGroup.addView(newView);
        }

        newView = inflater.inflate(R.layout.item_avis, null);

        if (viewGroup != null && newView != null)
        {
            ((TextView)newView.findViewById(R.id.title)).setText("2. Sympa");
            ((TextView)newView.findViewById(R.id.content)).setText("La nouvelle collection est chouette. Je viens d'acheter ce petit ensemble pour l'été");
            ((ImageView)newView.findViewById(R.id.icone)).setImageDrawable(getResources().getDrawable(R.drawable.icone_rodolpha));
            ((ImageView)newView.findViewById(R.id.image)).setImageDrawable(getResources().getDrawable(R.drawable.photo_avis));
            viewGroup.addView(newView);
        }


        return view;
    }
}
