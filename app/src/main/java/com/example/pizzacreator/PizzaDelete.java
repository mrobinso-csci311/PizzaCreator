package com.example.pizzacreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PizzaDelete extends AppCompatActivity {

    public EditText deletedPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_delete);
        deletedPizza = findViewById(R.id.deletedPizza);
    }

    public void deletePressed(View v){
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.delete(deletedPizza.getText().toString());
        Intent i = new Intent(this, PizzaView.class);
        startActivity(i);
    }
}
