package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PizzaReceipt extends AppCompatActivity {

    public TextView sizeBox;
    public CheckBox pepperoniReceipt;
    public CheckBox beefReceipt;
    public CheckBox sardineReceipt;
    public CheckBox pineappleReceipt;
    public CheckBox pickleReceipt;
    public CheckBox saladReceipt;
    public CheckBox breadReceipt;
    public CheckBox catReceipt;
    public TextView priceBox;
    public EditText pizzaNameEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_receipt);

        sizeBox = findViewById(R.id.sizeBox);
        pepperoniReceipt = findViewById(R.id.pepperoniReceipt);
        beefReceipt = findViewById(R.id.beefReceipt);
        sardineReceipt = findViewById(R.id.sardineReceipt);
        pineappleReceipt = findViewById(R.id.pineappleReceipt);
        pickleReceipt = findViewById(R.id.pickelReceipt);
        saladReceipt = findViewById(R.id.saladReceipt);
        breadReceipt = findViewById(R.id.breadReceipt);
        catReceipt = findViewById(R.id.catReceipt);
        priceBox = findViewById(R.id.priceBox);
        pizzaNameEntry = findViewById(R.id.pizzaNameEntry);

        sizeBox.setText(getIntent().getStringExtra("SIZE"));
        if(getIntent().getIntExtra("PEPPERONI",0) == 1){
            pepperoniReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("BEEF",0) == 1){
            beefReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("SARDINE",0) == 1){
            sardineReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("PINEAPPLE",0) == 1){
            pineappleReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("PICKLE",0) == 1){
            pickleReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("SALAD",0) == 1){
            saladReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("BREAD",0) == 1){
            breadReceipt.setChecked(true);
        }
        if(getIntent().getIntExtra("CAT",0) == 1){
            catReceipt.setChecked(true);
        }
        priceBox.setText(getIntent().getIntExtra("PRICE",0)+"");
    }

    public void homePressed(View v){
        Intent i = new Intent(this, MainActivity.class);
        String name = pizzaNameEntry.getText().toString();
        if(name.length()>0){
            DatabaseManager dbm = new DatabaseManager(this);
            String size = getIntent().getStringExtra("SIZE");
            String pepperoniNum = getIntent().getIntExtra("PEPPERONI",0)+"";
            String beefNum = getIntent().getIntExtra("BEEF",0)+"";
            String sardineNum = getIntent().getIntExtra("SARDINE",0)+"";
            String pineappleNum = getIntent().getIntExtra("PINEAPPLE",0)+"";
            String pickleNum = getIntent().getIntExtra("PICKLE",0)+"";
            String saladNum = getIntent().getIntExtra("SALAD",0)+"";
            String breadNum = getIntent().getIntExtra("BREAD",0)+"";
            String catNum = getIntent().getIntExtra("CAT",0)+"";
            String price = getIntent().getIntExtra("PRICE",0)+"";
            dbm.insert(name, size, pepperoniNum, beefNum, sardineNum, pineappleNum, pickleNum, saladNum, breadNum, catNum, price);
        }
        startActivity(i);
        finish();
    }
}
