package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class PizzaInfo extends AppCompatActivity {

    public TextView pizzaName;
    public TextView sizeInfo;
    public CheckBox pepperoniInfo;
    public CheckBox beefInfo;
    public CheckBox sardineInfo;
    public CheckBox pineappleInfo;
    public CheckBox pickleInfo;
    public CheckBox saladInfo;
    public CheckBox breadInfo;
    public CheckBox catInfo;
    public TextView priceInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_info);

        pizzaName = findViewById(R.id.pizzaName);
        sizeInfo = findViewById(R.id.sizeInfo);
        pepperoniInfo = findViewById(R.id.pepperoniInfo);
        beefInfo = findViewById(R.id.beefInfo);
        sardineInfo = findViewById(R.id.sardineInfo);
        pineappleInfo = findViewById(R.id.pineappleInfo);
        pickleInfo = findViewById(R.id.pickleInfo);
        saladInfo = findViewById(R.id.saladInfo);
        breadInfo = findViewById(R.id.breadInfo);
        catInfo = findViewById(R.id.catInfo);
        priceInfo = findViewById(R.id.priceInfo);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        String[] entry = dbm.get(name);
        pizzaName.setText(entry[0]);
        sizeInfo.setText(entry[1]);
        if (entry[2].equals("1")) {
            pepperoniInfo.setChecked(true);
        }
        if (entry[3].equals("1")){
            beefInfo.setChecked(true);
        }
        if (entry[4].equals("1")){
            sardineInfo.setChecked(true);
        }
        if (entry[5].equals("1")){
            pineappleInfo.setChecked(true);
        }
        if (entry[6].equals("1")){
            pickleInfo.setChecked(true);
        }
        if (entry[7].equals("1")){
            saladInfo.setChecked(true);
        }
        if (entry[8].equals("1")){
            breadInfo.setChecked(true);
        }
        if (entry[9].equals("1")){
            catInfo.setChecked(true);
        }
        priceInfo.setText(entry[10]);
    }
}
