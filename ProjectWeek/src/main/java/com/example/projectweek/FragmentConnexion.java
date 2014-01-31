package com.example.projectweek;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by parejo_p on 30/01/14.
 */
public class FragmentConnexion extends Fragment implements View.OnClickListener {
    public FragmentConnexion() {

    }

    View viewLogin = null;
    View viewPswd = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_connexion, container, false);
        viewLogin = view.findViewById(R.id.login);
        viewPswd = view.findViewById(R.id.password);
        view.findViewById(R.id.connect).setOnClickListener(this);
        view.findViewById(R.id.signUp).setOnClickListener(this);
        if (getPreference())
            checkLoginInfo();
        return (view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connect:
                checkLoginInfo();
                break;
            case R.id.signUp:
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }

    public boolean debugMode() {
        if (((EditText) viewLogin).getText().toString().equals("") && ((EditText) viewPswd).getText().toString().equals(""))
            return true;
        return false;
    }


    public void checkLoginInfo() {
        if (debugMode() == false) {
            if (checkPreference() == false) {
                Toast.makeText(getActivity(), getString(R.string.wrongLogInfo), Toast.LENGTH_SHORT).show();
                return;
            }
        }
        savePreference();
        Toast.makeText(getActivity(), getString(R.string.goodLogInfo), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ManageActivity.class);
        startActivity(intent);
    }

    public boolean getPreference() {
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", 0);
        String spLogin = sp.getString("login", null);
        String spPswd = sp.getString("password", null);

        if (spLogin == null || spPswd == null)
            return (false);
        ((EditText) viewLogin).setText(spLogin, TextView.BufferType.EDITABLE);
        ((EditText) viewPswd).setText(spPswd, TextView.BufferType.EDITABLE);
        return (true);
    }

    public void savePreference() {
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();
        Editable currentLogin = ((EditText) viewLogin).getText();
        Editable currentPassword = ((EditText) viewPswd).getText();

        if (currentLogin != null && currentPassword != null) {
            Ed.putString("login", currentLogin.toString());
            Ed.putString("password", currentPassword.toString());
            Ed.commit();
        }
    }

    public boolean checkPreference() {
        SharedPreferences sp = getActivity().getSharedPreferences("signUpInfo", 0);
        String signUpLogin = sp.getString("login", null);
        String signUpPswd = sp.getString("password", null);
        Editable currentLogin = ((EditText) viewLogin).getText();
        Editable currentPswd = ((EditText) viewPswd).getText();

        if (currentLogin == null || currentPswd == null || signUpLogin == null || signUpPswd == null)
            return (false);
        if (signUpLogin.equals(currentLogin.toString()) == true && signUpPswd.equals(currentPswd.toString()) == true)
            return (true);
        return (false);
    }
}
