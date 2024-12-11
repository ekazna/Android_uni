package com.example.lab7services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    String TAG = "mylog";

    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    public void onDestroy(){
        super.onCreate();
        Log.d(TAG, "onDestroy");
    }

    public int onStartCommand(Intent intent, int flag, int startID){
        Log.d(TAG, "onStartCommand");

        for (int i = 0; i < 6; i++) {
            Log.d(TAG, "i = "+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d(TAG, "MyRun #" + startID + " stopSelfResult (" + startID + ") = " + stopSelfResult(startID));

        return super.onStartCommand(intent, flag, startID);
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}