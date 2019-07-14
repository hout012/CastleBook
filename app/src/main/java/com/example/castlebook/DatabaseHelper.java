package com.example.castlebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbname = "BookCastle.db";
    //
    String tb1 = "Books";

    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tb1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AUTHORS TEXT,GENRE TEXT,LINK TEXT) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+tb1);
        onCreate(db);
    }

    public boolean addData(String name,String author, String Genre, String link){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("AUTHORS",author);
        contentValues.put("GENRE",Genre);
        contentValues.put("LINK",link);
        long result = db.insert(tb1,null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+tb1,null);
        return res;
    }

    public Cursor getData(String genre){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+tb1+" WHERE GENRE = ?",new String[]{genre});
        return res;
    }

    public void clearData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE "+tb1);
    }

}
