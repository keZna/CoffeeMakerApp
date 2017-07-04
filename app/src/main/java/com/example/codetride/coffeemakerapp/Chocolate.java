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

public class Chocolate extends AppCompatActivity {

    private Button btnAdd, btnMinus, btnOrder;
    private TextView lblQuantityCho,lblTotalCho, lblDisplay;
    private boolean isTrue = true;
    private int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolate);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        lblQuantityCho = (TextView) findViewById(R.id.lblQuantityCho);
        lblTotalCho = (TextView) findViewById(R.id.lblTotalCho);

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                    if(counter<20){
                        counter++;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Chocolate.this,"You have reached the maximum number of cups",Toast.LENGTH_SHORT).show();
                        Display(20);
                        Total(20);
                    }
                }
            }
        });

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTrue){
                    if(counter>0){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Chocolate.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
                        lblQuantityCho.setText(String.valueOf(""));
                        lblTotalCho.setText(String.valueOf(""));
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
                lblQuantityCho.setVisibility(View.INVISIBLE);
                lblTotalCho.setVisibility(View.INVISIBLE);

                String total=lblTotalCho.getText().toString();
                String display=lblQuantityCho.getText().toString();

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
        lblQuantityCho.setText(String.valueOf(counter));
    }

    public void Total(int counter){
        int sum = counter * 19;
        lblTotalCho.setText(String.valueOf("R"+sum));
    }
}
