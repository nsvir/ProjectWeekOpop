package com.example.projectweek;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
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
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private PlaceholderFragment mPlaceholderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlaceholderFragment = new PlaceholderFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FragmentConnexion())
                    .commit();
        }

    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
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

    /*      Picture methods     */

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private IPictureTaker mPictureTaker = null;

    public void takeAPicture(IPictureTaker pictureTaker) {

        mPictureTaker = pictureTaker;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            if (mPictureTaker != null)
                mPictureTaker.getPicture(imageBitmap);
        }
    }

    /*      End Picture methods     */
    /*      Share methods     */

    public void shareSomething() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    /*      End Share methods     */


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
            Toast.makeText(getActivity(), "mon text", Toast.LENGTH_SHORT).show();
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            if (rootView == null)
                rootView = inflater.inflate(R.layout.fragment_main, null);
            if (rootView != null) {
                ((TextView) rootView.findViewById(R.id.text)).setText(R.string.bluetooth_off);
                rootView.findViewById(R.id.button).setOnClickListener(this);
            }
            return rootView;
        }

        @Override
        public void onClick(View view) {
            bluetoothActivated = !bluetoothActivated;
            if (bluetoothActivated)
                ((TextView) getView().findViewById(R.id.text)).setText(R.string.bluetooth_on);
            else
                ((TextView) getView().findViewById(R.id.text)).setText(R.string.bluetooth_off);
        }
    }

}
