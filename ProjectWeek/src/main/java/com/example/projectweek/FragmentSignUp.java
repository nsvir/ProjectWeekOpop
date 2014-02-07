package com.example.projectweek;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by parejo_p on 30/01/14.
 */
public class FragmentSignUp extends Fragment implements View.OnClickListener {
    public FragmentSignUp() {

    }

    EditText signUpLogin = null;
    EditText signUpPswd = null;
    TextView sexMale = null;
    TextView sexFemale = null;
    char sex = '0';

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        (sexMale = (TextView) view.findViewById(R.id.sex_m)).setOnClickListener(this);
        (sexFemale = (TextView) view.findViewById(R.id.sex_f)).setOnClickListener(this);

        view.findViewById(R.id.signUp).setOnClickListener(this);
        signUpLogin = ((EditText) view.findViewById(R.id.loginText));
        signUpPswd = ((EditText) view.findViewById(R.id.passwordText));
        return (view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUp:
                signUp();
                break;
            default:
                selectSex(view.getId());
                break;
        }
    }

    public void selectSex(int id) {
        if (id == R.id.sex_m) {
            sexMale.setBackgroundColor(getActivity().getResources().getColor(R.color.color3));
            sexFemale.setBackgroundColor(getActivity().getResources().getColor(R.color.color7));
            sex = 'm';
        } else {
            sexFemale.setBackgroundColor(getActivity().getResources().getColor(R.color.color3));
            sexMale.setBackgroundColor(getActivity().getResources().getColor(R.color.color7));
            sex = 'f';
        }
    }

    public void signUp() {
        SharedPreferences sp = getActivity().getSharedPreferences("signUpInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();
        Editable loginText = signUpLogin.getText();
        Editable passwordText = signUpPswd.getText();

        //Verification should start here
        if (sex != '0' && loginText != null && passwordText != null && !loginText.toString().equals("") && !passwordText.toString().equals("")) {
            Ed.putString("login", loginText.toString());
            Ed.putString("password", passwordText.toString());
            Ed.commit();
            getActivity().finish();
        } else {
            //Should be more precise
            Toast.makeText(getActivity(), "Informations incorrectes!", Toast.LENGTH_SHORT).show();
        }
    }
}
