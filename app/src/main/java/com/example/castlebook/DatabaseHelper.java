package com.example.castlebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String dbname = "BookCastle.db";
    //
    String tb1 = "Books";
    //
    String tb2 = "Authors";
    //
    String tb3 = "Category";
    //
    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tb1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+tb1);
    }
}
