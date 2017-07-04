package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Black_tea extends AppCompatActivity {

    private TextView lblQuantityBlack, lblTotalBlack,lblDisplay;
    private Button btnAdd, btnMinus, btnOrder;
    private int counter=0;
    public Intent intent;
    private boolean isTrue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_tea);

        lblQuantityBlack = (TextView) findViewById(R.id.lblQuantityBlack);
        lblTotalBlack = (TextView) findViewById(R.id.lblTotalBlack);
        lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnOrder= (Button) findViewById(R.id.btnOrder);

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                        if(counter<20){
                            counter++;
                            Display(counter);
                            Total(counter);
                        }else{
                            Display(20);
                            Toast.makeText(Black_tea.this,"You have reached the maximum of cups",Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });

        btnMinus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue){
                    if(counter>=1){
                        counter--;
                        Display(counter);
                        Total(counter);
                    }else{
                        Toast.makeText(Black_tea.this,"Add a cup in order to place your order",Toast.LENGTH_SHORT).show();
                        Total(0);
                        Display(0);
                        lblTotalBlack.setText(String.valueOf(""));
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
                lblQuantityBlack.setVisibility(View.INVISIBLE);
                lblTotalBlack.setVisibility(View.INVISIBLE);

                String total=lblTotalBlack.getText().toString();
                String display=lblQuantityBlack.getText().toString();

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
       lblQuantityBlack.setText(String.valueOf(counter));
    }

    public void Total(int totals){
        int sum = totals * 13;
        lblTotalBlack.setText(String.valueOf("R "+sum));
    }

}
