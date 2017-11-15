package com.example.viacheslav_ivanov.drinkometer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Viacheslav_Ivanov on 9/18/2017.
 */

public class databaseConnector extends SQLiteOpenHelper {
    /* Inner class that defines the table contents */
/* TOD table structure */
        public static final String TOD_TABLE_NAME = "tod_main";
        public static final String COLUMN_NAME_ID = "tod_id";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_TODSTART = "todstart";
        public static final String COLUMN_NAME_TODEND = "todend";

    private static final String SQL_CREATE_TOD_TABLE =
            "CREATE TABLE " + TOD_TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_STATUS + " TEXT," +
                    COLUMN_NAME_USERNAME + " TEXT," +
                    COLUMN_NAME_TODEND + " TEXT," +
                    COLUMN_NAME_TODSTART + " TEXT);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TOD_TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "twentyone.db";

    public databaseConnector (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TOD_TABLE);
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}