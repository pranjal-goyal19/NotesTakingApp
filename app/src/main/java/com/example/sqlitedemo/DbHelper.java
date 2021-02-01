package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private  static final String dbname="Usernotes.db";
    private static final String tablename="notestbl";
  
   private static final String id="id";
    private static final String coln_note="note";

    public DbHelper( Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="create table notestbl (id INTEGER  primary key, note text)";
        db.execSQL(qry);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notestbl");
        onCreate(db);

    }

    public String addRecord(String p1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        
        cv.put(coln_note, p1);

        long res = db.insert(tablename, null, cv);

        if (res == -1)
            return "failed";
        else

            return "success";


    }
    public Cursor readalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select * from notestbl order by id asc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }

    public void deletedata(String textnote )
    {
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(tablename,coln_note  +"  = ?",new String[]{textnote}) ;
        db.close();

    }


}
