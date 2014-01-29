package com.example.projectweek;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentQuestionnaire extends Fragment implements View.OnClickListener, PictureTaker{

    public FragmentQuestionnaire() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_questionnaire, container, false);

        view.findViewById(R.id.imageButton).setOnClickListener(this);
        view.findViewById(R.id.shareButton).setOnClickListener(this);

        return (view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton:
                ((MainActivity)getActivity()).takeAPicture(this);
                break;
            case R.id.shareButton:
                ((MainActivity)getActivity()).shareSomething();
                break;

        }
    }

    public void setImage(Bitmap bitmap)
    {
        ((ImageView)getView().findViewById(R.id.image)).setImageBitmap(bitmap);
    }

    @Override
    public void getPicture(Bitmap bitmap) {
        setImage(bitmap);
    }
}