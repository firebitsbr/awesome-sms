package com.eightbitforest.awesomesms;

import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.eightbitforest.awesomesms.model.AwesomeSMSDBHelper;
import com.eightbitforest.awesomesms.network.Messenger;
import com.eightbitforest.awesomesms.observer.ContactObserver;
import com.eightbitforest.awesomesms.observer.TextObserver;

/**
 * Service that starts the content observers.
 *
 * @author Forrest Jones
 */
// TODO: Ask for permissions
public class AwesomeSMSService extends Service {

    // TODO: start sticky
    @Override
    public void onCreate() {
        Messenger messenger = new Messenger();
        AwesomeSMSDBHelper helper = new AwesomeSMSDBHelper(getBaseContext());
        SQLiteDatabase database = helper.getWritableDatabase();

        // Create and register TextObserver
        TextObserver textObserver = new TextObserver(messenger, database, getContentResolver());
        textObserver.register();

        // Create and register ContactObserver
        ContactObserver contactObserver = new ContactObserver(messenger, database, getContentResolver());
        contactObserver.register();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
