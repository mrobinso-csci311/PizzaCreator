package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class PizzaToppings extends AppCompatActivity {

    public CheckBox pepperoniCheck;
    public CheckBox beefCheck;
    public CheckBox sardineCheck;
    public CheckBox pineappleCheck;
    public CheckBox pickleCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_toppings);

        pepperoniCheck = findViewById(R.id.pepperoniCheck);
        beefCheck = findViewById(R.id.beefCheck);
        sardineCheck = findViewById(R.id.sardineCheck);
        pineappleCheck = findViewById(R.id.pineappleCheck);
        pickleCheck = findViewById(R.id.pickleCheck);
    }

    public void toppingsNextPressed(View v){
        Intent i = new Intent(this, PizzaSides.class);
        int price = getIntent().getIntExtra("PRICE",0);
        int pepperoni = 0;
        int beef = 0;
        int sardine = 0;
        int pineapple = 0;
        int pickle = 0;
        if (pepperoniCheck.isChecked()) {
            price += 1;
            pepperoni = 1;
        }
        if (beefCheck.isChecked()){
            price += 3;
            beef = 1;
        }
        if (sardineCheck.isChecked()){
            price += 5;
            sardine = 1;
        }
        if (pineappleCheck.isChecked()){
            price += 7;
            pineapple = 1;
        }
        if (pickleCheck.isChecked()) {
            price += 100;
            pickle = 1;
        }
        i.putExtra("SIZE",getIntent().getStringExtra("SIZE"));
        i.putExtra("PEPPERONI",pepperoni);
        i.putExtra("BEEF",beef);
        i.putExtra("SARDINE",sardine);
        i.putExtra("PINEAPPLE",pineapple);
        i.putExtra("PICKLE",pickle);
        i.putExtra("PRICE",price);
        startActivity(i);
    }
}
