package com.example.saglikd2;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class Alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Intent mServiceIntent;
    private BackService mYourService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alarm_layout);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });

    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("Service status", "Running");
                return true;
            }
        }
        Log.i ("Service status", "Not running");
        return false;
    }

    @Override
    protected void onDestroy() {
        stopService(mServiceIntent);
        super.onDestroy();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("Saat: " + hourOfDay + ":" + minute);

        TextView saatText = findViewById(R.id.kurulansaat);
        saatText.setText(hourOfDay);

        TextView dakikaText = findViewById(R.id.kurulandakika);
        dakikaText.setText(minute);

        mYourService = new BackService();
        mServiceIntent = new Intent(this, mYourService.getClass());
        if (!isMyServiceRunning(mYourService.getClass())) {
            mServiceIntent.putExtra("hod", hourOfDay);
            mServiceIntent.putExtra("min", minute);
            startService(mServiceIntent);
        }
        /*
        Intent intent = new Intent(Alarm.this, BackService.class);
        intent.putExtra("hod", hourOfDay);
        intent.putExtra("min", minute);

        EditText ed1 = findViewById(R.id.alarm_notu);
        String title = ed1.getText().toString().trim();
        intent.putExtra("tit", title);

        startService(intent);
        */
    }


    public void alarmKur(View view, int hourOfDay, int minute){

        //Intent intent = new Intent(Alarm.this, BackService.class);
        //intent.putExtra("hod", hourOfDay);
        //intent.putExtra("min", minute);

        //EditText ed1 = findViewById(R.id.alarm_notu);
        //String title = ed1.getText().toString().trim();

        //intent.putExtra("tit", title);
        //startService(intent);


        startService(new Intent(this, BackService.class));
    }

    public void sendNot(){
        EditText ed1 = findViewById(R.id.alarm_notu);
        String title = ed1.getText().toString().trim();

        NotificationManager notif = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notifx = new Notification.Builder(getApplicationContext()).setContentTitle("Şekerim").setContentText(title).setSmallIcon(R.drawable.app_icon).build();
        notif.notify(0, notifx);
    }

}
