package com.example.projectweek;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by svirch_n on 31/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentAvis extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_avis, container, false);

        Typeface mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");

        if ((view != null))
        {
            ((TextView) view.findViewById(R.id.op)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Medium.ttf"));
            ((TextView) view.findViewById(R.id.address)).setTypeface(mTypeface);
            ((TextView) view.findViewById(R.id.description)).setTypeface(mTypeface);

        }


        ViewGroup viewGroup = null;
        if (view != null)
            viewGroup = (ViewGroup) view.findViewById(R.id.container);

        View newView = inflater.inflate(R.layout.item_avis, null);

        if (viewGroup != null && newView != null) {
            ((TextView) newView.findViewById(R.id.title)).setText("1. Déçu");
            ((TextView) newView.findViewById(R.id.content)).setText("Le magasin est mal rangé. Les étalages sont éparpillés");
            ((TextView) newView.findViewById(R.id.content)).setTypeface(mTypeface);
            ((ImageView) newView.findViewById(R.id.icone)).setImageDrawable(getResources().getDrawable(R.drawable.photo_sophie));
            viewGroup.addView(newView);
        }

        newView = inflater.inflate(R.layout.item_avis, null);

        if (viewGroup != null && newView != null) {

            ((TextView) newView.findViewById(R.id.title)).setText("2. Sympa");
            ((TextView) newView.findViewById(R.id.content)).setText("La nouvelle collection est chouette. Je viens d'acheter ce petit ensemble pour l'été");
            ((TextView) newView.findViewById(R.id.content)).setTypeface(mTypeface);
            ((ImageView) newView.findViewById(R.id.icone)).setImageDrawable(getResources().getDrawable(R.drawable.photo_rodolpha));
//
//            Bitmap originalBmp = BitmapFactory.decodeResource(getActivity().getResources(),
//                    R.drawable.photo_avis);
//            Bitmap bitmap = Bitmap.createBitmap(originalBmp, 0, 0, originalBmp.getWidth(), 450);
            ((ImageView) newView.findViewById(R.id.image)).setImageDrawable(getResources().getDrawable(R.drawable.photo_avis_miniature));
            (newView.findViewById(R.id.image)).setOnClickListener(this);

            viewGroup.addView(newView);
        }

        newView = inflater.inflate(R.layout.item_avis, null);

        if (viewGroup != null && newView != null) {
            ((TextView) newView.findViewById(R.id.title)).setText("3. Au Top!");
            ((TextView) newView.findViewById(R.id.content)).setText("Je viens de dévaliser le magasin");
            ((TextView) newView.findViewById(R.id.content)).setTypeface(mTypeface);
            ((ImageView) newView.findViewById(R.id.icone)).setImageDrawable(getResources().getDrawable(R.drawable.photo_sophie));
            viewGroup.addView(newView);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ImageActivity.class);
        intent.putExtra(MyActivity.EXTRA_EVENT, ((AvisActivity) getActivity()).getColor());
        startActivity(intent);
    }
}
