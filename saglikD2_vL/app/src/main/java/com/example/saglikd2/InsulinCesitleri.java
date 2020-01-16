package com.example.saglikd2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class InsulinCesitleri extends AppCompatActivity {

    ExpandableRelativeLayout mycontent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insulin_cesitleri);


        mycontent = findViewById(R.id.mycontent1);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent2);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent3);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent4);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent5);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent6);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent7);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent8);
        mycontent.collapse();

        mycontent = findViewById(R.id.mycontent9);
        mycontent.collapse();
    }

    public void show1(View view) {
        mycontent = findViewById(R.id.mycontent1);
        mycontent.toggle();

    }

    public void show2(View view) {
        mycontent = findViewById(R.id.mycontent2);
        mycontent.toggle();
    }

    public void show3(View view) {
        mycontent = findViewById(R.id.mycontent3);
        mycontent.toggle();
    }

    public void show4(View view) {
        mycontent = findViewById(R.id.mycontent4);
        mycontent.toggle();
    }

    public void show5(View view) {
        mycontent = findViewById(R.id.mycontent5);
        mycontent.toggle();
    }

    public void show6(View view) {
        mycontent = findViewById(R.id.mycontent6);
        mycontent.toggle();
    }

    public void show7(View view) {
        mycontent = findViewById(R.id.mycontent7);
        mycontent.toggle();
    }

    public void show8(View view) {
        mycontent = findViewById(R.id.mycontent8);
        mycontent.toggle();
    }

    public void show9(View view) {
        mycontent = findViewById(R.id.mycontent9);
        mycontent.toggle();
    }




}
