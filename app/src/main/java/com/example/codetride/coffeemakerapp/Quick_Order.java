package com.example.codetride.coffeemakerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quick_Order extends AppCompatActivity {


    public Button btnsendQuick, btndisplay;
    public CheckBox amer, blac, capp, choc, espr, flat, ice, latt, maro;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick__order);

        btndisplay= (Button) findViewById(R.id.display);
        btnsendQuick = (Button) findViewById(R.id.sendQuick);
        amer = (CheckBox) findViewById(R.id.Americano);
        blac = (CheckBox) findViewById(R.id.Black);
        capp = (CheckBox) findViewById(R.id.Cappuccino);
        choc = (CheckBox) findViewById(R.id.Chocolate);
        espr = (CheckBox) findViewById(R.id.Espresso);
        flat = (CheckBox) findViewById(R.id.Flat);
        ice = (CheckBox) findViewById(R.id.Ice);
        latt = (CheckBox) findViewById(R.id.Latte);
        maro = (CheckBox) findViewById(R.id.Marocchino);


        btnsendQuick.setVisibility(View.INVISIBLE);

        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String item = "Your order: ";

                if (amer.isChecked()){
                    item = item+"\nAmericano";
                }
                if (blac.isChecked()){
                    item= item+"\nBlack";
                }

                if (capp.isChecked()){
                    item= item+"\nCappuccino";
                }

                if (choc.isChecked()){
                    item= item+"\nChocolate";
                }

                if (espr.isChecked()){
                    item= item+"\nEspresso";
                }

                if (flat.isChecked()){
                    item= item+"\nFlat";
                }

                if (ice.isChecked()){
                    item= item+"\nIce";
                }

                if (latt.isChecked()){
                    item= item+"\nLatte";
                }

                if (maro.isChecked()){
                    item= item+"\nMarocchino";
                }

                if (item.length()>12){
                    Toast.makeText(getApplication(),item,Toast.LENGTH_SHORT).show();
                    btnsendQuick.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(getApplication(),"select your items",Toast.LENGTH_SHORT).show();
                    btnsendQuick.setVisibility(View.INVISIBLE);
                }

            }
        });

        btnsendQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String item = "Your order:\n ";

                if (amer.isChecked()){
                    item = item+"Americano\n";
                }
                if (blac.isChecked()){
                    item= item+"Black\n";
                }

                if (capp.isChecked()){
                    item= item+"Cappuccino\n";
                }

                if (choc.isChecked()){
                    item= item+"Chocolate\n";
                }

                if (espr.isChecked()){
                    item= item+"Espresso\n";
                }

                if (flat.isChecked()){
                    item= item+"Flat\n";
                }

                if (ice.isChecked()){
                    item= item+"Ice\n";
                }

                if (latt.isChecked()){
                    item= item+"Latte\n";
                }

                if (maro.isChecked()){
                    item= item+"Marocchino\n";
                }

                if (item.length()>12){
                    intent=new Intent(getApplication(),MainActivity.class);
                    Toast.makeText(getApplication(),"Your order was successfully sent to us :-)",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }






            }
        });
    }
}
