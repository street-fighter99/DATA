package com.example.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="STOP.db";
    public static  final String TABLE_NAME="user_id";
    public static  final String COLO1="ID";
    public static  final String COLO2="USER";
    public static  final String COLO3="PASS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+"("+COLO1 +" INTEGER PRIMARY KEY AUTOINCREMENT ,"+COLO2+" TEXT,"+COLO3+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean Insert(String username, String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLO2,username);
        contentValues.put(COLO3,pass);
        long result= db.insert(TABLE_NAME, null,contentValues);
        if(result==-1)

            return false;
        else
            return true;





    }

}
