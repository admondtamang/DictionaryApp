package com.e.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName="DictionaryDB.db";
    private static final int dbVersion=1;
    private static final String tblWord="tblWord";
    private static final String WordId="WordId";
    private static final String Word="Word";
    private static final String Meaning="Meaning";

    public MyHelper(Context context) {
        super(context, databaseName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+tblWord+
                "("+
                WordId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Word+" TEXT," +
                Meaning+" TEXT" + ")";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean InsertData(String word,String Meaning,SQLiteDatabase db){
        try {
            String query="INSERT INTO tblWord(Word,Meaning) values('"+word+"','"+Meaning+"')";
            db.execSQL(query);
            return true;
        }
        catch (Exception e){
            Log.d( "Error:",e.toString());
            return false;
        }
    }
}
