package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        Button btnExit = (Button) findViewById(R.id.btnExit);
        ImageView imglogo1 = (ImageView) findViewById(R.id.imgLogo1);
        ImageView imglogo2 = (ImageView) findViewById(R.id.imgLogo2);
        ImageView imglogo3 = (ImageView) findViewById(R.id.imgLogo3);
        ImageView imglogo4 = (ImageView) findViewById(R.id.imgLogo4);
        ImageView imglogo5 = (ImageView) findViewById(R.id.imgLogo5);
        ImageView imglogo6 = (ImageView) findViewById(R.id.imgLogo6);
        ImageView imglogo7 = (ImageView) findViewById(R.id.imgLogo7);
        ImageView imglogo8 = (ImageView) findViewById(R.id.imgLogo8);
        ImageView imglogo9 = (ImageView) findViewById(R.id.imgLogo9);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imglogo1.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Americano.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo2.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Chocolate.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo3.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Latte.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo4.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Espresso.class);
                startActivity(intent);
                finish();
            }

        });

        imglogo5.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Marocchino.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo6.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Cappuccino.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo7.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Ice_tea.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo8.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Flat_white.class);
                startActivity(intent);
                finish();
            }
        });

        imglogo9.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this,Black_tea.class);
                startActivity(intent);
                finish();
            }
        });




    }
}
