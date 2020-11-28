package com.example.materialapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database( Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(Name Text, Number Text, Email Text, password Text,rePassword Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String name, String number, String email, String password, String rePassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Number",number);
        contentValues.put("Email",email);
        contentValues.put("password",password);
        contentValues.put("rePassword",rePassword);
        long result = db.insert("users",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor readData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users", null);
        return cursor;
    }
}
