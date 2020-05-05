package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class PizzaSize extends AppCompatActivity {

    public RadioButton small;
    public RadioButton medium;
    public RadioButton large;
    public RadioButton xl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_size);

        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        xl = findViewById(R.id.xl);
    }

    public void sizeNextPressed(View v){
        Intent i = new Intent(this, PizzaToppings.class);
        String size = null;
        int price;
        if (small.isChecked()) {
            size = "small";
            price = 10;
        } else if (medium.isChecked()) {
            size = "medium";
            price = 12;
        } else if (large.isChecked()) {
            size = "large";
            price = 15;
        }else{
            size  = "xl";
            price = 20;
        }
        i.putExtra("SIZE",size);
        i.putExtra("PRICE",price);
        startActivity(i);
    }
}
