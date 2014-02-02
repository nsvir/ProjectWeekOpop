package com.example.projectweek;

import android.app.ActionBar;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by svirch_n on 30/01/14.
 * nicolas.svirchevsky@epitech.eu
 */
public class QuestionnaireActivity extends MyActivity implements IDialogResponse {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    private IPictureTaker mPictureTaker = null;
    static private boolean mAsk = true;
    private BluetoothDialog mBluetoothDialog = null;
    private BluetoothAdapter bt;
    private boolean btWasActivated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FragmentQuestionnaire())
                    .commit();
        }

        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color1)));
        setTitle("QUESTIONNAIRE");
        bt = BluetoothAdapter.getDefaultAdapter();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.questionnaire, menu);
//        return true;
//    }

    public void onPositiveButton() {
        if (!bt.isEnabled())
            bt.enable();
        mAsk = false;
    }

    public void onNegativeButton() {
        mAsk = true;
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        bluetoothManager();
        if (bt != null && !bt.isEnabled() && !mAsk)
            bt.enable();
    }

    @Override
    public void onStop() {
        if (bt != null && !btWasActivated)
            bt.disable();
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mBluetoothDialog != null) {
            mBluetoothDialog.dismiss();
        }
    }

    /*      Picture methods     */

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


    public void bluetoothManager() {
        if (bt == null) {
            Toast.makeText(this, "Bluetooth Not Available in device", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            if (!bt.isEnabled()) {
                btWasActivated = false;
                if (mAsk) {
                    mBluetoothDialog = new BluetoothDialog(this);
                    mBluetoothDialog.show(getFragmentManager(), null);
                } else
                    bt.enable();
            } else {
                btWasActivated = true;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (mBluetoothDialog != null && mBluetoothDialog.isVisible())
            finish();
        super.onBackPressed();
    }
}
