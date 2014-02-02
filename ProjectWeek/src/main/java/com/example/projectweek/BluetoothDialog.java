package com.example.projectweek;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nicolas on 21/10/13.
 */

public class BluetoothDialog extends DialogFragment {

    private Dialog mDialog;
    private Activity mContext;
    private View mView;

    public BluetoothDialog(Activity context) {
        mContext = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);



        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Oui", null); /* null cause override in onStart */

        builder.setView(onCreateView());

        mDialog = builder.create();
        return mDialog;
    }

    public View onCreateView() {
        mView = mContext.getLayoutInflater().inflate(R.layout.dialog_bluetooth, null);

        if (mView == null)
            return null;


        Typeface mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        ((TextView)mView.findViewById(R.id.text)).setTypeface(mTypeface);

        return mView;
    }
}