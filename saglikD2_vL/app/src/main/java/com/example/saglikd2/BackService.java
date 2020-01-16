package com.example.saglikd2;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class BackService extends Service {
    public int counter=0;       // yeni

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;

    Calendar calendar = Calendar.getInstance();
    int hourOfDayq;
    int minuteq;
    String titlex;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O)
            startMyOwnForeground();
        else
            startForeground(1, new Notification());

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                Toast.makeText(context, "Service is still running", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 10000);


                int saat = calendar.get(Calendar.HOUR_OF_DAY);
                int dakika = calendar.get(Calendar.MINUTE);

                if(saat == hourOfDayq && dakika == minuteq){
                    sendNot();
                    Toast.makeText(context, "this is", Toast.LENGTH_SHORT).show();
                    handler.removeCallbacks(runnable);
                }

            }
        };

        handler.postDelayed(runnable, 15000);

    }



    @RequiresApi(Build.VERSION_CODES.O)
    private void startMyOwnForeground()
    {
        Toast.makeText(context, "app running", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "working 1", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        //handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();

        super.onDestroy();          // yeni
        stoptimertask();

        Intent broadcastIntent = new Intent();          // yeni
        broadcastIntent.setAction("restartservice");
        broadcastIntent.setClass(this, Restarter.class);
        this.sendBroadcast(broadcastIntent);
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
    }

    @Override                                                   // yeni
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "on start command running", Toast.LENGTH_LONG).show();
        /*
        hourOfDayq = intent.getIntExtra("hod",0);
        minuteq = intent.getIntExtra("min",0);

        titlex = intent.getStringExtra("tit");
        */

        startTimer();
        return START_STICKY;
    }


    private Timer timer;                    // yeni
    private TimerTask timerTask;
    public void startTimer() {
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                Log.i("Count", "=========  "+ (counter++));
            }
        };
        timer.schedule(timerTask, 1000, 1000); //
        Toast.makeText(context, "start timer running", Toast.LENGTH_SHORT).show();
    }

    public void stoptimertask() {
        Toast.makeText(context, "stop timer running", Toast.LENGTH_SHORT).show();
        if (timer != null) {
            timer.cancel();     // yeni
            timer = null;
        }
    }


    public void sendNot(){
        Toast.makeText(this, titlex, Toast.LENGTH_LONG).show();

        //NotificationManager notif = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //Notification notifx = new Notification.Builder(getApplicationContext()).setContentTitle("Şekerim").setContentText(titlex).setSmallIcon(R.drawable.app_icon).build();
        //notif.notify(0, notifx);
    }


}
