package com.example.projectweek;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
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
 * nicolas.svirchevsky@epitech.eu
 */
public class BluetoothDialog extends DialogFragment {

    private AlertDialog mDialog;
    static private Activity mContext;
    private View mView;
    static private IDialogResponse response;

    public BluetoothDialog() {

    }

    public BluetoothDialog(Activity context) {
        mContext = context;
        response = (IDialogResponse) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                response.onNegativeButton();
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                response.onPositiveButton();
            }
        });

        builder.setView(onCreateView());

        mDialog = builder.create();

        mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button positive = mDialog.getButton(Dialog.BUTTON_POSITIVE);
                if (positive != null) {
                    positive.setBackgroundColor(getResources().getColor(R.color.color2));
                    positive.setTextColor(getResources().getColor(android.R.color.white));
                    if (mContext != null)
                        positive.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Bold.ttf"));
                }

                Button negative = mDialog.getButton(Dialog.BUTTON_NEGATIVE);
                if (negative != null) {
                    negative.setBackgroundColor(getResources().getColor(R.color.color2));
                    negative.setTextColor(getResources().getColor(android.R.color.white));
                    if (mContext != null)
                        negative.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Bold.ttf"));
                }
            }
        });

        mDialog.setCanceledOnTouchOutside(false);

        return mDialog;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        response.onCancelButton();
    }

    public View onCreateView() {
        if (mContext != null) {
            mView = mContext.getLayoutInflater().inflate(R.layout.dialog_bluetooth, null);

            if (mView == null)
                return null;


            Typeface mTypeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Bold.ttf");
            ((TextView) mView.findViewById(R.id.text)).setTypeface(mTypeface);
        }
        return mView;
    }
}