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

public class Americano extends AppCompatActivity {

    private TextView lblQuantityAmeri, lblTotalAmericano;
    private Button btnAdd, btnMinus, btnOrder;
    private boolean isTrue = true;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        lblQuantityAmeri = (TextView) findViewById(R.id.lblQuantityAmeri);
        lblTotalAmericano = (TextView) findViewById(R.id.lblTotalAmericano);
        final TextView lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTrue){
                        if(counter<20){
                            counter++;
                            Display(counter);
                            Total(counter);
                        }else {
                            Toast.makeText(Americano.this,"You have reached the maximum number of cups",Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTrue){
                    if(counter>1){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Americano.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
                        lblTotalAmericano.setText(String.valueOf(""));
                        lblQuantityAmeri.setText(String.valueOf(""));
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
                lblQuantityAmeri.setVisibility(View.INVISIBLE);
                lblTotalAmericano.setVisibility(View.INVISIBLE);

                String total=lblTotalAmericano.getText().toString();
                String display=lblQuantityAmeri.getText().toString();

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
        lblQuantityAmeri.setText(String.valueOf(counter));
    }

    public void Total(int total){
        int sum = total * 15;
        lblTotalAmericano.setText(String.valueOf("R"+sum));
    }
}
