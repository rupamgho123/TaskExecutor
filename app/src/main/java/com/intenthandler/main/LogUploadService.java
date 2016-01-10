package com.intenthandler.main;

import android.content.Intent;
import android.util.Log;

/**
 * Created by rupam.ghosh on 10/01/16.
 */
public class LogUploadService extends IntentHandlerService {

    int count;

    @Override
    public void processIntent(Intent intent)
    {
        Log.d("LogUploadService", "Processing Intent " + (++count));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
