package com.example.viacheslav_ivanov.drinkometer;

import android.text.format.DateFormat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.String.valueOf;

/**
 * Created by Viacheslav_Ivanov on 11/14/2017.
 */

public class TwentyOneDay {
    final int TodLength = 21;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy:HH:mm");
    final static String TOD_LOG_TAG = "TOD_LOG_TAG";
    int TodId;
    Date DayStart;
    Date DayEnd;
    String Status;
    public String User = "TestUser";

    public TwentyOneDay(Date dayStart) {
        this.DayStart = dayStart;
        this.Status = "new";
        this.User = "User";
        calendar.setTime(dayStart);
        calendar.add(Calendar.DATE, TodLength);
        this.DayEnd = calendar.getTime();
        Log.d(TOD_LOG_TAG,"Object created");
    }

    public Boolean CheckTodExists() {
        return false;
    }

    //@TODO delete later. Debug purposes
    public void ShowStatus() {
        Log.d(TOD_LOG_TAG, this.Status +" "+ this.User+" "+  this.dateFormat.format(DayStart)+" "+
                this.dateFormat.format(DayEnd)+" "+valueOf(CheckTodExists()));

    }
}
