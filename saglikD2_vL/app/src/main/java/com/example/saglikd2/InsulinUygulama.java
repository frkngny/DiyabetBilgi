package com.example.saglikd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class InsulinUygulama extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insulin_uygulamasi);

    }

    public void gotoinsulinbolgeleri(View view){
        Intent intent = new Intent(InsulinUygulama.this, InsulinBolgeleri.class);
        startActivity(intent);
    }

    public void gotoinsulinsaklama(View view){
        Intent intent = new Intent(InsulinUygulama.this, InsulinSaklama.class);
        startActivity(intent);
    }

    public void gotoinsulincesitleri(View view){
        Intent intent = new Intent(InsulinUygulama.this, InsulinCesitleri.class);
        startActivity(intent);
    }
}
