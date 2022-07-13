package com.example.gpstrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(TTNumber TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    public  Boolean InsertData(String TTNumber, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TTNumber",TTNumber);
        values.put("password",password);
        long result =db.insert("users",null,values);
        if(result==-1) return false;
        else
            return true;

    }
    public Boolean checkTTNumber(String TTNumber){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from users where TTNumber=?", new String[]{TTNumber});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
