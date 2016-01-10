package com.intenthandler.main;


import java.util.Vector;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public abstract class IntentHandlerService extends Service
{

	public static String TAG = IntentHandlerService.class.getSimpleName();
	
	@Override
	public IBinder onBind(Intent arg0)
	{
		return null;
	}

	Vector<Intent> taskQueue;
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		taskQueue = new Vector<Intent>();
		runnable = new Runnable() {
			
			@Override
			public void run() {
				
				while(!onStartCalled){}
				
				while(!taskQueue.isEmpty())
				{
					Intent intent = taskQueue.remove(0);
					processIntent(intent);
				}
				stopThisService();
			}
		};
		thread = new Thread(runnable);
		thread.start();
	}
	
	Thread thread;
	
	boolean onStartCalled = false;
	
	@Override
	public void onStart(Intent intent, int startId)
	{
		super.onStart(intent, startId);
		if(intent!=null)
			taskQueue.add(intent);
		onStartCalled = true;
	}
	
	Runnable runnable;
	
	public abstract void processIntent(Intent intent);
	
	
	void stopThisService()
	{
		Log.d(TAG, "Stopping Service");
		stopSelf();
	}
	
}
