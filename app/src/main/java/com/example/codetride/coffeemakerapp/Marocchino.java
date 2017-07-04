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

public class Marocchino extends AppCompatActivity {

    private TextView lblQuantityMaro, lblTotalMaro, lblDisplay;
    private Button btnAdd, btnMinus, btnOrder;
    private int counter;
    private boolean isTrue = true;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marocchino);

        lblQuantityMaro= (TextView) findViewById(R.id.lblQuantityMaro);
        lblTotalMaro= (TextView) findViewById(R.id.lblTotalMaro);
        lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnMinus= (Button) findViewById(R.id.btnMinus);
        btnOrder= (Button) findViewById(R.id.btnOrder);

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                    if(counter>0){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else {
                        lblQuantityMaro.setText(String.valueOf(""));
                        lblTotalMaro.setText(String.valueOf(""));
                        Toast.makeText(Marocchino.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
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
                        Display(20);
                        Total(20);
                        Toast.makeText(Marocchino.this,"You have reached the maixmum number of cups",Toast.LENGTH_SHORT).show();
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
                lblQuantityMaro.setVisibility(View.INVISIBLE);
                lblTotalMaro.setVisibility(View.INVISIBLE);

                String total=lblTotalMaro.getText().toString();
                String display=lblQuantityMaro.getText().toString();

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
        lblQuantityMaro.setText(String.valueOf(counter));
    }

    public void Total(int counter){
        int sum = counter*18;
        lblTotalMaro.setText(String.valueOf("R"+sum));
    }
}
