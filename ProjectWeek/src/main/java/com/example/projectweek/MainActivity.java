package com.example.projectweek;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private PlaceholderFragment mPlaceholderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlaceholderFragment = new PlaceholderFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mPlaceholderFragment)
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        boolean bluetoothActivated = false;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            if (rootView == null)
                rootView = inflater.inflate(R.layout.fragment_main, null);
            if (rootView != null)
            {
                ((TextView)rootView.findViewById(R.id.text)).setText(R.string.bluetooth_off);
                rootView.findViewById(R.id.button).setOnClickListener(this);
            }
            return rootView;
        }

        @Override
        public void onClick(View view) {
            bluetoothActivated = !bluetoothActivated;
            if (bluetoothActivated)
                ((TextView)getView().findViewById(R.id.text)).setText(R.string.bluetooth_on);
            else
                ((TextView)getView().findViewById(R.id.text)).setText(R.string.bluetooth_off);
        }
    }

}
