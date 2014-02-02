package com.example.projectweek;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentQuestionnaire extends Fragment implements View.OnClickListener, IPictureTaker {

    private int numberQuestion = 0;

    private String[] mQuestions = {
            "Que pensez vous de la nouvelle collection printemps/été ?",
            "Que pensez vous de la qualité du service ?",
            "Avez vous acheté un article ?",
    };

    private String[][] mResponses = {
            {"Génial", "Cool", "Ca passe", "Médiocre"},
            {"Génial", "Cool", "Ca passe", "Médiocre"},
            {"Oui", "Non"}
    };

    public FragmentQuestionnaire() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_questionnaire, container, false);

        return (view);
    }

    @Override
    public void onResume() {
        super.onResume();
        fillView();
    }

    private void fillView() {
        View view = getView();

        if (numberQuestion >= mQuestions.length)
            return;
        if (view == null)
            return;

        ((TextView) view.findViewById(R.id.text_number)).setText((numberQuestion + 1) + "");
        ((TextView) view.findViewById(R.id.text_max)).setText(mQuestions.length + "");
        ((TextView) view.findViewById(R.id.question)).setText(mQuestions[numberQuestion]);

        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.container);
        viewGroup.removeAllViews();
        View newView;

        if (viewGroup != null)
            for (int i = 0; i < mResponses[numberQuestion].length; i++) {
                newView = getActivity().getLayoutInflater().inflate(R.layout.item_quesitonnaire, viewGroup, false);
                if (newView != null) {
                    ((TextView) newView.findViewById(R.id.text)).setText(mResponses[numberQuestion][i]);
                    newView.setOnClickListener(this);
                    viewGroup.addView(newView);
                }
            }
    }

    @Override
    public void onClick(View view) {
        numberQuestion++;
        fillView();
    }

    public void setImage(Bitmap bitmap) {
        ((ImageView) getView().findViewById(R.id.image)).setImageBitmap(bitmap);
    }

    @Override
    public void getPicture(Bitmap bitmap) {
        setImage(bitmap);
    }

}

//        switch (view.getId()) {
//            case R.id.imageButton:
//                ((QuestionnaireActivity) getActivity()).takeAPicture(this);
//                break;
//            case R.id.shareButton:
//                ((QuestionnaireActivity) getActivity()).shareSomething();
//                break;
//        }
