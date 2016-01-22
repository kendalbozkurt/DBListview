package com.example.el_tayr.listviewlistactivity;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by El-tayr on 25.12.2015.
 */
public class CDataBase extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Countries";
    private static String Country_ID = "id";
    private static String Country_NAME = "country_name";
    private static String Country_FLAG_NAME = "country_flag_name";
    private static String Country_FLAG = "country_flag";
    private static String Country_INF = "country_inf";
    public CDataBase(Context context) {
        super(context, "Countries1", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + Country_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Country_NAME + " TEXT,"
                + Country_FLAG_NAME+" TEXT,"
                + Country_FLAG + " BLOB,"
                + Country_INF + " TEXT"+" )";
        db.execSQL(CREATE_TABLE);
    }
    public void addCountry(String countryName,String countryFlagName, byte[] countryFLAG,String countryInf){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Country_NAME, countryName);
        values.put(Country_FLAG_NAME, countryFlagName);
        values.put(Country_FLAG,countryFLAG);
        values.put(Country_INF,countryInf);
        db.insert(TABLE_NAME, null, values);
        db.close();


    }
    public List<Bitmap> getCountryFlag(){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int index=cursor.getColumnIndex(Country_FLAG);

        byte[] byteArray;
        List<Bitmap> splittedBitmaps =new ArrayList<Bitmap>();
        while(cursor.moveToNext()) {
            byteArray = cursor.getBlob(index);
            Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            splittedBitmaps.add(bm);
        }
        db.close();

        return splittedBitmaps;

    }
    public List<String> getCountryName(){
        SQLiteDatabase db = this.getReadableDatabase();
        String uname="";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        List<String> array = new ArrayList<String>();
        while(cursor.moveToNext()){
            uname = cursor.getString(cursor.getColumnIndex(Country_NAME));
            array.add(uname);
        }

        db.close();

        return array;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
