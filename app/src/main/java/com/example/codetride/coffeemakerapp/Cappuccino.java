package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Cappuccino extends AppCompatActivity {

    private TextView lblQuantityCap, lblTotalCap, lblDisplay;
    private Button btnAdd, btnMinus, btnOrder;
    private boolean isTrue = true;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cappuccino);

        lblQuantityCap = (TextView) findViewById(R.id.lblQuantityCap);
        lblTotalCap = (TextView) findViewById(R.id.lblTotalCap);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTrue){
                    if(counter>0){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Cappuccino.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
                        lblQuantityCap.setText(String.valueOf(""));
                        lblTotalCap.setText(String.valueOf(""));
                    }
                }
            }
        });

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTrue){
                    if(counter<20){
                        counter++;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Cappuccino.this,"You have reached the maximum number of cups",Toast.LENGTH_SHORT).show();
                        Display(20);
                        Total(20);
                    }
                }
            }
        });

        btnOrder.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMinus.setVisibility(View.INVISIBLE);
                btnAdd.setVisibility(View.INVISIBLE);
                btnOrder.setVisibility(View.INVISIBLE);
                lblQuantityCap.setVisibility(View.INVISIBLE);
                lblTotalCap.setVisibility(View.INVISIBLE);

                String total=lblTotalCap.getText().toString();
                String display=lblQuantityCap.getText().toString();

                lblDisplay.setText("SUMMARY ORDER\n\n"+"Name: Themba Khoza\n"+"Quantity: "+display+"\nTotal cost: "+total+"\nThank You");


                ProgressBar proMenu = (ProgressBar) findViewById(R.id.proMenu);
                proMenu.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getApplication(),Menu.class);
                        Toast.makeText(getApplication(),"Your order is successfully sent",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                },2500);
            }
        });
    }

    public void Display(int counter){
        lblQuantityCap.setText(String.valueOf(counter));
    }

    public void Total(int counter){
        int sum = counter *16;
        lblTotalCap.setText(String.valueOf("R"+sum));
    }
}
