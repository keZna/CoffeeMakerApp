package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    private Intent intent;
    private ImageView imglogo1;
    private ImageView imglogo2;
    private ImageView imglogo3;
    private ImageView imglogo4;
    private ImageView imglogo5;
    private ImageView imglogo6;
    private ImageView imglogo7;
    private ImageView imglogo8;
    private ImageView imglogo9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        imglogo1 = (ImageView) findViewById(R.id.imgLogo1);
        imglogo2 = (ImageView) findViewById(R.id.imgLogo2);
        imglogo3 = (ImageView) findViewById(R.id.imgLogo3);
        imglogo4 = (ImageView) findViewById(R.id.imgLogo4);
        imglogo5 = (ImageView) findViewById(R.id.imgLogo5);
        imglogo6 = (ImageView) findViewById(R.id.imgLogo6);
        imglogo7 = (ImageView) findViewById(R.id.imgLogo7);
        imglogo8 = (ImageView) findViewById(R.id.imgLogo8);
        imglogo9 = (ImageView) findViewById(R.id.imgLogo9);

        imglogo1.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Americano.class);
                startActivity(intent);
            }
        });

        imglogo2.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Chocolate.class);
                startActivity(intent);
            }
        });

        imglogo3.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Latte.class);
                startActivity(intent);
            }
        });
        imglogo4.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Espresso.class);
                startActivity(intent);
            }

        });

        imglogo5.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Marocchino.class);
                startActivity(intent);
            }
        });

        imglogo6.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Cappuccino.class);
                startActivity(intent);
            }
        });

        imglogo7.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Ice_tea.class);
                startActivity(intent);
            }
        });

        imglogo8.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Flat_white.class);
                startActivity(intent);
            }
        });

        imglogo9.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Black_tea.class);
                startActivity(intent);
            }
        });
    }
}
