package com.example.saglikd2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.r0adkll.slidr.model.SlidrInterface;

public class MainActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    private static final String TAG = "Anasayfa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG,"onMenuItemClick: clicked menu item: " + item);

                switch (item.getItemId()){
                    case R.id.LogOut:
                        Log.d(TAG,"onMenuItemClıck: Navigating to profile preferences.");
                    case R.id.help_main:
                        Log.d(TAG,"onMenuItemClıck: Navigating to profile preferences.");
                        Intent intent = new Intent(MainActivity.this, Help.class);
                        startActivity(intent);
                }

                return false;
            }
        });
    }


    public void gotokatologlar(View view){
        Intent intent = new Intent(MainActivity.this, EgitimKatologlari.class);
        startActivity(intent);
    }

    public void goToAlarm(View view){
        Intent intent = new Intent(MainActivity.this, Alarm.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }
}
