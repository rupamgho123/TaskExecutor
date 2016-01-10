package com.intenthandler.main;

/**
 * Created by rupam.ghosh on 10/01/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);

        int loopCount = 10;
        for(int i=0;i<loopCount;i++)
        {
            startIntent(null);
        }

    }
    public void startIntent(View v)
    {
        Intent myIntent = new Intent(this,LogUploadService.class);
        startService(myIntent);
    }
}
