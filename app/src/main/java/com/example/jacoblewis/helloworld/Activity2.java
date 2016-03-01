package com.example.jacoblewis.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;
public class Activity2 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    public void onRadioClick(View v) {
        //Activates radio button
        RadioButton radio = (RadioButton) findViewById(R.id.radioButton);
         if (radio.isChecked()) radio.setChecked(false);
         else radio.setChecked(true);
        //Button btnTest = (Button) findViewById(R.id.button3);
        //btnTest.setBackgroundColor(Color.rgb(11, 179, 23));
    }

    public void btnTest2(View v) {
        RelativeLayout background = (RelativeLayout) findViewById(R.id.backgroundId);
        background.setBackgroundColor(Color.rgb(11, 179, 23));
    }

    public class SeekColorActivity extends Activity2 {
        private int seekR, seekG, seekB;
        SeekBar redSeekBar,greenSeekBar, blueSeekBar;
        RelativeLayout mScreen;
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.RelativeLayout);
            mScreen=(RelativeLayout) findViewById(R.id.backgroundId);
            redSeekBar = (SeekBar) findViewById(R.id.seekBar3);
            greenSeekBar = (SeekBar) findViewById(R.id.seekBar2);
            blueSeekBar = (SeekBar) findViewById(R.id.seekBar);
            updateBackground();

            redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
            greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
            blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        }
        private SeekBar.OnSeekBarChangeListener seekBarChangeListener
                = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        private void updateBackground(){
            seekR = redSeekBar.getProgress();
            seekG = greenSeekBar.getProgress();
            seekB = blueSeekBar.getProgress();
            mScreen.setBackgroundColor(
                    0xff000000
                    + seekR * 0x10000
                    + seekG * 0x100
                    + seekB);
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jacoblewis.helloworld/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jacoblewis.helloworld/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
