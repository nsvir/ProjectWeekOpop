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
import android.widget.Toast;

/**
 * Created by svirch_n on 29/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class FragmentQuestionnaire extends Fragment implements View.OnClickListener, IPictureTaker {

    public FragmentQuestionnaire() {

    }

    BluetoothAdapter bt;
    boolean btWasActivated = false;
    static boolean btAsk = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_questionnaire, container, false);

        if (view != null) {
            view.findViewById(R.id.imageButton).setOnClickListener(this);
            view.findViewById(R.id.shareButton).setOnClickListener(this);
        }
        bt = BluetoothAdapter.getDefaultAdapter();
        bluetoothManager();
        return (view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton:
                ((QuestionnaireActivity) getActivity()).takeAPicture(this);
                break;
            case R.id.shareButton:
                ((QuestionnaireActivity) getActivity()).shareSomething();
                break;
        }
    }

    public void setImage(Bitmap bitmap) {
        ((ImageView) getView().findViewById(R.id.image)).setImageBitmap(bitmap);
    }

    @Override
    public void getPicture(Bitmap bitmap) {
        setImage(bitmap);
    }

    @Override
    public void onStop() {
        if (!btWasActivated)
            bt.disable();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!bt.isEnabled())
            bt.enable();
    }

    public void bluetoothManager() {
        if (bt == null) {
            Toast.makeText(getActivity(), "Bluetooth Not Available in device", Toast.LENGTH_SHORT).show();
        } else {
            if (!bt.isEnabled()) {
                btWasActivated = false;
                if (btAsk) {
                    bt.enable();
                } else
                    bt.enable();
            } else {
                btWasActivated = true;
            }
        }
    }
}