package com.example.projectweek;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by parejo_p on 30/01/14.
 */
public class SignupActivity extends MyActivity {

    FragmentSignUp fragment = new FragmentSignUp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("INSCRIPTION");

        fragment = new FragmentSignUp();

        setTitle("S'INSCRIRE");
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color7)));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    protected void finishMe() {

    }
}