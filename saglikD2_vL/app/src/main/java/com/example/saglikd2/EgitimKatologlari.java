package com.example.saglikd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class EgitimKatologlari extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egitim_katalog_layout);
    }

    public void gotokansekeriolcum(View view){
        Intent intent = new Intent(EgitimKatologlari.this, KanSekeriOlcum.class);
        startActivity(intent);
    }

    public void gotoinsulinguyg(View view){
        Intent intent = new Intent(EgitimKatologlari.this, InsulinUygulama.class);
        startActivity(intent);
    }

    public void gotobeslenme(View view){
        Intent intent = new Intent(EgitimKatologlari.this, Beslenme.class);
        startActivity(intent);
    }

    public void gotoilaclar(View view){
        Intent intent = new Intent(EgitimKatologlari.this, DiyabetikIlaclar.class);
        startActivity(intent);
    }

    public void gotoegzersiz(View view){
        Intent intent = new Intent(EgitimKatologlari.this, Egzersiz.class);
        startActivity(intent);
    }

}
