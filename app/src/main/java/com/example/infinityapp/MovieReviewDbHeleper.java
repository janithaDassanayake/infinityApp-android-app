package com.example.infinityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieReviewDbHeleper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "movieReview.db";
    public static final String TABLE_NAME = "Review_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MOVIENAME";
    public static final String COL_3 = "RATING";
    public static final String COL_4 = "COMMENT";

    public MovieReviewDbHeleper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY,MOVIENAME TEXT,RATING TEXT,COMMENT TEXT)");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }






    public boolean insertData(String MOVIENAME,String RATING,String COMMENT) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(COL_2,MOVIENAME);
        contentValues.put(COL_3,RATING);
        contentValues.put(COL_4,COMMENT);

        long result = db.insert(TABLE_NAME,null ,contentValues);


        if(result == -1)
            return false;
        else
            return true;
    }




    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }



    public boolean updateData(String ID,String MOVIENAME,String RATING,String COMMENT)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,MOVIENAME);
        contentValues.put(COL_3,RATING);
        contentValues.put(COL_4,COMMENT);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { ID });
        return true;
    }





    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}