package com.example.saglikd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class AcilisEkran extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acilis_ekran);

        Slidr.attach(this);
    }

    public void gotogiris(View view ){
        Intent intent = new Intent(AcilisEkran.this, MainActivity.class);
        startActivity(intent);
    }
}
