package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Button btnMenuh;
    private Button btnOrder;
    private Button btnExit;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenuh= (Button) findViewById(R.id.btnMenu);
        btnOrder= (Button) findViewById(R.id.btnQuickOrder);
        btnExit= (Button) findViewById(R.id.btnExit);

//        btnMenu.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                intent = new Intent(MainActivity.this,Menu.class);
//                startActivity(intent);
//            }
//        });
        btnMenuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(MainActivity.this,Menu.class);
               startActivity(intent);

            }
        });

        btnExit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       btnOrder.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View v) {
               intent = new Intent(MainActivity.this,Quick_Order.class);
               startActivity(intent);
           }
       });

    }
}
