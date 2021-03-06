package com.eightbitforest.awesomesms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Main activity of the app. Will be used for settings later.
 *
 * @author Forrest Jones
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(getApplicationContext(), AwesomeSMSService.class));

        Log.i(AwesomeSMS.TAG, "FCM Device ID: " + FirebaseInstanceId.getInstance().getToken());
    }
}
