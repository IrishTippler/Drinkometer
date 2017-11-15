package com.example.viacheslav_ivanov.drinkometer;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Viacheslav_Ivanov on 11/14/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_LOG_TAG = "DBLOGTAG";
    private final String DBname = "TODdatabase";
    private final String TODmain = "TODmain";
    //TOD Filds
    private final static String TODid = "TODid";
    private final static String TODDayStart = "TODstart";
    private final static String TODDayEnd = "TODend";
    private final static String TODUser = "TODUser";
    private final static String TODstatus = "TODstatus";



    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "TODdatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(DB_LOG_TAG, "On create method started");
        db.execSQL("create table '"+TODmain+"' ( "
                + TODid + " integer not null primary key autoincrement,"
                + TODDayStart+ " text,"
                + TODDayEnd+ " text,"
                + TODUser+ " text,"
                + TODstatus+ " text);");
        Log.d(DB_LOG_TAG, "TODmain table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
