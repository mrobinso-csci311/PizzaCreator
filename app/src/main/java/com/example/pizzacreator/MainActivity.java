package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPressed(View v){
        Intent i = new Intent(this, PizzaSize.class);
        startActivity(i);
    }

    public void savePressed(View v){
        Intent i = new Intent(this, PizzaView.class);
        startActivity(i);
    }

    public void deletePressed(View v){
        Intent i = new Intent(this, PizzaDelete.class);
        startActivity(i);
    }
}
