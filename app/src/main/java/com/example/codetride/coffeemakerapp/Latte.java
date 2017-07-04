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

public class Latte extends AppCompatActivity {


    private TextView lblQuantityLatte, lblTotalLatte, lblDisplay;
    private Button btnAdd, btnMinus, btnOrder;
    private int counter = 0;
    private boolean isTrue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latte);

        lblQuantityLatte = (TextView) findViewById(R.id.lblQuantityLatte);
        lblTotalLatte = (TextView) findViewById(R.id.lblTotalLatte);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        lblDisplay= (TextView) findViewById(R.id.lblDisplay);

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                    if(counter<20){
                        counter++;
                        Display(counter);
                        Total(counter);
                    }else {
                        Toast.makeText(Latte.this,"You have reach the maximum number of cups: ",Toast.LENGTH_SHORT).show();
                        Display(20);
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
                    }else{
                        Toast.makeText(Latte.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
                        Display(0);
                        Total(0);
                        lblTotalLatte.setText(String.valueOf(""));
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
                lblQuantityLatte.setVisibility(View.INVISIBLE);
                lblTotalLatte.setVisibility(View.INVISIBLE);

                String total=lblTotalLatte.getText().toString();
                String display=lblQuantityLatte.getText().toString();

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


    public void Display(int count){
        lblQuantityLatte.setText(String.valueOf(count));
    }

    public void Total(int count){
        int sum = count * 17;
        lblTotalLatte.setText(String.valueOf("R"+sum));
    }

}
