package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class PizzaSides extends AppCompatActivity {

    public CheckBox saladCheck;
    public CheckBox breadCheck;
    public CheckBox catCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_sides);

        saladCheck = findViewById(R.id.saladCheck);
        breadCheck = findViewById(R.id.breadCheck);
        catCheck = findViewById(R.id.catCheck);
    }

    public void finishPressed(View v){
        Intent i = new Intent(this, PizzaReceipt.class);
        int price = getIntent().getIntExtra("PRICE",0);
        int salad = 0;
        int bread = 0;
        int cat = 0;
        if (saladCheck.isChecked()) {
            price += 3;
            salad = 1;
        }
        if (breadCheck.isChecked()) {
            price += 5;
            bread = 1;
        }
        if (catCheck.isChecked()){
            price += 0;
            cat = 1;
        }
        i.putExtra("SIZE",getIntent().getStringExtra("SIZE"));
        i.putExtra("PEPPERONI",getIntent().getIntExtra("PEPPERONI",0));
        i.putExtra("BEEF",getIntent().getIntExtra("BEEF",0));
        i.putExtra("SARDINE",getIntent().getIntExtra("SARDINE",0));
        i.putExtra("PINEAPPLE",getIntent().getIntExtra("PINEAPPLE",0));
        i.putExtra("PICKLE",getIntent().getIntExtra("PICKLE",0));
        i.putExtra("SALAD",salad);
        i.putExtra("BREAD",bread);
        i.putExtra("CAT",cat);
        i.putExtra("PRICE",price);
        startActivity(i);
    }
}
