package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ice_tea extends AppCompatActivity {

   private Button btnAdd, btnMinus, btnOrder;
    private TextView lblQuantityIce, lblTotalIce;
    private int counter;
    private boolean isTrue= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_tea);

        lblTotalIce = (TextView) findViewById(R.id.lblTotalIce);
        lblQuantityIce= (TextView) findViewById(R.id.lblQuantityIce);
        final TextView lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnMinus= (Button) findViewById(R.id.btnMinus);

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                    if(counter>0){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else {
                        lblQuantityIce.setText(String.valueOf(""));
                        lblTotalIce.setText(String.valueOf(""));
                        Toast.makeText(Ice_tea.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(Ice_tea.this,"You have reached your maximum number of cups",Toast.LENGTH_SHORT).show();
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
                lblQuantityIce.setVisibility(View.INVISIBLE);
                lblTotalIce.setVisibility(View.INVISIBLE);

                String total=lblTotalIce.getText().toString();
                String display=lblQuantityIce.getText().toString();

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
        lblQuantityIce.setText(String.valueOf(counter));
    }

    public void Total(int counter){
        int sum = counter*14;
        lblTotalIce.setText(String.valueOf("R"+sum));
    }
}
