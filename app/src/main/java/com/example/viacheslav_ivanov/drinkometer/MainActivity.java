package com.example.viacheslav_ivanov.drinkometer;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //main view objects:
    TextView label_top;
    Button button_start, button_fail, button_delete, button_statistic;
    public static final String MAIN_LOG_TAG = "MAIN_LOG";

    DBHelper dbHelper;
    //trying to create TOD object:
    TwentyOneDay TOD = new TwentyOneDay(new Date());




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating database listener instance:
        dbHelper = new DBHelper(this);



        //finding elements:
        Log.d(MAIN_LOG_TAG, "finding elements");
        label_top = (TextView) findViewById(R.id.label_top);
        button_start = (Button) findViewById(R.id.button_start);
        button_fail = (Button) findViewById(R.id.button_fail);
        button_delete = (Button) findViewById(R.id.button_delete);
        button_statistic = (Button) findViewById(R.id.button_statistic);
        //applying on click listener to the buttons:
        Log.d(MAIN_LOG_TAG, "Applying click listener to the buttons");
        button_start.setOnClickListener(this);
        button_fail.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_statistic.setOnClickListener(this);

     }
    @Override
    public void onClick(View v) {
        //@TODO resolve this shit! no writeable database, app crashed
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.button_start:
                // кнопка ОК
                label_top.setText("StartTod");
                TOD.ShowStatus();
                Log.d(MAIN_LOG_TAG, "Start pressed");
                break;
            case R.id.button_fail:
                // кнопка Cancel
                Log.d(MAIN_LOG_TAG, "Fail pressed");
                label_top.setText("Fail Tod");
                break;
            case R.id.button_delete:
                // кнопка Cancel
                Log.d(MAIN_LOG_TAG, "Cancel pressed");
                label_top.setText("Delete Tod");
                break;
            case R.id.button_statistic:
                // кнопка Cancel
                Log.d(MAIN_LOG_TAG, "Statistic pressed");
                label_top.setText("Tod stat");
                Toast.makeText(this, "Statistics stubbed", Toast.LENGTH_LONG).show();
                break;
        }dbHelper.close();
    }
}
