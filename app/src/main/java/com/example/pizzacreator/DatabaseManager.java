package com.example.pizzacreator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "GameDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table PizzaTable(";
        sql += "id integer primary key autoincrement, ";
        sql += "name text, size text, pepperoni text, beef text, sardine text, pineapple text, pickle text, salad text, bread text, cat text, price text)";
        db.execSQL(sql);
    }

    public ArrayList<String> getTitles(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db  = getWritableDatabase();
        String sql = "select * from PizzaTable";
        Cursor cursor  = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            list.add(name);
        }
        db.close();
        return list;
    }

    public String[] get(String pizzaTitle){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from PizzaTable where name = '"+pizzaTitle+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[11];
        if (cursor.moveToFirst()){
            String name = cursor.getString(1);
            String size = cursor.getString(2);
            String pepperoni = cursor.getString(3);
            String beef = cursor.getString(4);
            String sardine = cursor.getString(5);
            String pineapple = cursor.getString(6);
            String pickle = cursor.getString(7);
            String salad = cursor.getString(8);
            String bread = cursor.getString(9);
            String cat = cursor.getString(10);
            String price = cursor.getString(11);
            entry[0] = name;
            entry[1] = size;
            entry[2] = pepperoni;
            entry[3] = beef;
            entry[4] = sardine;
            entry[5] = pineapple;
            entry[6] = pickle;
            entry[7] = salad;
            entry[8] = bread;
            entry[9] = cat;
            entry[10] = price;
        }
        db.close();
        return entry;
    }

    public void insert(String name, String size, String pepperoni, String beef, String sardine, String pineapple, String pickle, String salad, String bread, String cat, String price){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into PizzaTable values(";
        sql += "null, '"+name+"', '"+size+"', '"+pepperoni+"', '"+beef+"', '"+sardine+"', '"+pineapple+"', '"+pickle+"', '"+salad+"', '"+bread+"', '"+cat+"', '"+price+"')";
        db.execSQL(sql);
        db.close();
    }

    public void delete(String requestedDelete){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from PizzaTable where name = '"+requestedDelete+"'";
        db.execSQL(sql);
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
