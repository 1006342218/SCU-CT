package com.mycompany.myjiemian;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class create_activity extends AppCompatActivity implements View.OnClickListener {
    private EditText input;
    private Button bt_create;
    private Button bt_back;
    private MyDatabaseHelper dbHelper;
    private String inputText;
    private EditText date;
    private Button date_button;
    private EditText time;
    private Button time_button;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private Calendar ca;
    private String total;
    private AlarmManager mAlarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("建立新提醒");
        setContentView(R.layout.create);
        dbHelper = new MyDatabaseHelper(this, "Event.db", null, 1);
        find_and_modify_text_view();
        mAlarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    }

    private void find_and_modify_text_view() {
        input = (EditText) findViewById(R.id.create_edit);
        bt_create = (Button) findViewById(R.id.create_create_button);
        bt_create.setOnClickListener(this);
        bt_back = (Button) findViewById(R.id.create_back_button);
        bt_back.setOnClickListener(this);
        date_button = (Button) findViewById(R.id.date_button);
        date_button.setOnClickListener(this);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        time_button = (Button) findViewById(R.id.time_button);
        time_button.setOnClickListener(this);

         ca = Calendar.getInstance();
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH);
        day = ca.get(Calendar.DAY_OF_MONTH);
        hour = ca.get(Calendar.HOUR_OF_DAY);
        minute = ca.get(Calendar.MINUTE);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_create_button:
                inputText = input.getText().toString();
                addData();
                sendmissage();
                back();
                break;
            case R.id.create_back_button:
                back();
                break;
            case R.id.date_button:
                setdate();
                break;
            case R.id.time_button:
                settime();
                break;
        }
    }

    public void addData() {
        total = date.getText().toString() + time.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("events", inputText);
        values.put("time", total);
        values.put("year", year);
        values.put("month", month);
        values.put("day", day);
        values.put("hour", hour);
        values.put("minute", minute);
        db.insert("event", null, values);
        values.clear();
    }

    public void back() {
        Intent intent = new Intent();
        intent.setClass(create_activity.this, richenbiao.class);
        startActivity(intent);
    }


    public void setdate() {
        DatePickerDialog dpd = new DatePickerDialog(create_activity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                date.setText(arg1 + "-" + (arg2 + 1) + "-" + arg3 + " ");
                year=arg1;
                month=arg2;
                day=arg3;
            }
        }, year, month, day);

        dpd.show();
    }

    public void settime() {
        TimePickerDialog tpt = new TimePickerDialog(create_activity.this, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker arg0, int h, int mi) {
                time.setText(h + ":" + mi);
                hour=h;
                minute=mi;
            }
        }, hour, minute, true);
        tpt.show();
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {

            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();

            if (isShouldHideInput(v, ev)) {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    private void  sendmissage(){
        Intent intent = new Intent(this, alarmserver.class);
        intent.setAction(year+"-"+month+"-"+day+" "+hour+":"+minute);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
        ca.set(year,month,day,hour,minute,0);
        /*
        String time =String.valueOf(ca.getTimeInMillis()-System.currentTimeMillis());
        Toast.makeText(create_activity.this,time,Toast.LENGTH_SHORT).show();
       */
        mAlarmManager.set(AlarmManager.RTC_WAKEUP, ca.getTimeInMillis(),pi);
        ca.clear();
    }

    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = { 0, 0 };
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom){
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
            }
        return false;
    }
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    }



