package com.example.se_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// on mySQL : INSERT INTO `studs`.`students_attendance`
//(`name`,
//`surname`,
//`group`,
//`username`,
//`password`)
//VALUES
//("Mihnea", "Dumitrescu", "1240f", "mihnea.dumitrescu", "dumitrescu1234");
//
//select * from `studs`.`students_attendance`;


public class DBHelper  extends SQLiteOpenHelper
{
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if(result == -1){
            return false;
        } else{
            return true;
        }
    }

    public boolean checkUserName(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?", new String[] {username});

        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return  false;
        }
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ? and password = ?",
                new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        } else{
            return false;
        }
    }
}
