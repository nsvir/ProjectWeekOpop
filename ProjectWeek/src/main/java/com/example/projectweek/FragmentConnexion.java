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

    View login = null;
    View pswd = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_connexion, container, false);
        login = view.findViewById(R.id.login);
        pswd = view.findViewById(R.id.password);
        view.findViewById(R.id.connect).setOnClickListener(this);
        if (getPreference())
            checkLoginInfo();
        return (view);
    }

    @Override
    public void onClick(View view) {
        checkLoginInfo();
    }

    public void checkLoginInfo() {
        savePreference();
        Toast.makeText(getActivity(), "Connected!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), CategorieActivity.class);
        startActivity(intent);

    }

    public boolean getPreference() {
        SharedPreferences sp1 = getActivity().getSharedPreferences("loginInfo", 0);
        String loginSP = sp1.getString("login", null);
        String pswdSP = sp1.getString("password", null);

        if (loginSP == null || pswdSP == null)
            return (false);
        ((EditText) login).setText(loginSP, TextView.BufferType.EDITABLE);
        ((EditText) pswd).setText(pswdSP, TextView.BufferType.EDITABLE);
        return (true);
    }

    public void savePreference() {
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();
        Editable loginText = ((EditText) login).getText();
        Editable passwordText = ((EditText) pswd).getText();

        if (loginText != null && passwordText != null) {
            Ed.putString("login", loginText.toString());
            Ed.putString("password", passwordText.toString());
            Ed.commit();
        }
    }

    public void logout()
    {
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", 0);
        SharedPreferences.Editor Ed = sp.edit();

        Ed.putString("login", null);
        Ed.putString("password", null);
        Ed.commit();
    }
}
