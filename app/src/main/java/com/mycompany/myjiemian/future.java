package com.mycompany.myjiemian;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class future extends AppCompatActivity implements View.OnClickListener {
    private List<ev> evList = new ArrayList<>();
    private ListView listView;
    private Button bt_delete_future;
    public MyDatabaseHelper dbHelper;
    public SQLiteDatabase db;
    private Button bt_back;
    private AlarmManager mAlarmManager;
    private int year,month,day,hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        setTitle("提醒");
        dbHelper = new MyDatabaseHelper(this, "Event.db", null, 1);
        db = dbHelper.getWritableDatabase();
        listView = (ListView) findViewById(R.id.future_listview);            //列表对象
        bt_delete_future = (Button) findViewById(R.id.button);               //按钮对象
        bt_delete_future.setOnClickListener(this);          //按钮监听
        bt_back = (Button) findViewById(R.id.button2);
        bt_back.setOnClickListener(this);
        setEvList();//调用获取函数获取event.db的数据
        evAdapter adapter = new evAdapter(future.this, R.layout.ev, evList);//搭建适配器
        listView.setAdapter(adapter);                                           //调用适配器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //列表点击
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//单项点击
                final ev evpoint = evList.get(position);  //判断点击位置
                AlertDialog.Builder more = new AlertDialog.Builder(future.this);
                LayoutInflater factory = LayoutInflater.from(future.this);
                final View update = factory.inflate(R.layout.moreinformation, null);
                more.setTitle("更新");
                more.setIcon(android.R.drawable.ic_dialog_info);
                more.setView(update);
                final EditText update_create = (EditText) update.findViewById(R.id.update_edit);
                final String oldtime = evpoint.getTime();
                update_create.setText(evpoint.getEvent());
                more.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                String newinpput = update_create.getText().toString();
                                db.execSQL("update  Event set events = ? where time =?", new String[]{newinpput,oldtime});
                                Toast.makeText(future.this, "更新成功", Toast.LENGTH_SHORT).show();
                                evList.clear();
                                setEvList();
                                frash();
                            }
                        });
                more.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                            }
                        });
                more.setNeutralButton("删除记录",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                mAlarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                                Intent intent = new Intent(future.this, alarmserver.class);
                                intent.setAction(year+"-"+month+"-"+day+" "+hour+":"+minute);
                                PendingIntent pi = PendingIntent.getBroadcast(future.this, 0, intent, 0);
                                db.execSQL("delete from Event where events =?", new String[]{evpoint.getEvent()});
                                mAlarmManager.cancel(pi);
                                frash();
                            }
                        });
                more.show();


            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                delete();
                back();
                break;
            case R.id.button2:
                back();
                break;
        }
    }

    public void frash(){
        Intent intent = new Intent();
        intent.setClass(future.this, future.class);
        startActivity(intent);
    }

    public void back() {
        Intent intent = new Intent();
        intent.setClass(future.this, richenbiao.class);
        startActivity(intent);
    }

    public void delete() {
        db = dbHelper.getWritableDatabase();
        db.delete("Event", null, null);
        evList.clear();
        Toast.makeText(future.this, "数据清除成功", Toast.LENGTH_SHORT).show();
    }

    private void setEvList() {
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Event", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                ev ev = new ev();
                String event = cursor.getString(cursor.getColumnIndex("events"));
                 year = cursor.getInt(cursor.getColumnIndex("year"));
                month = cursor.getInt(cursor.getColumnIndex("month"));
                 day = cursor.getInt(cursor.getColumnIndex("day"));
                 hour = cursor.getInt(cursor.getColumnIndex("hour"));
                 minute = cursor.getInt(cursor.getColumnIndex("minute"));
                String time = (year+"-"+(month+1)+"-"+day+" "+hour+":"+minute);
                ev.setevent(event);
                ev.settime(time);
                evList.add(ev);
            } while (cursor.moveToNext());
        }
        cursor.close();
        if (evList.size() == 0) {
            Toast.makeText(future.this, "没有提醒",
                    Toast.LENGTH_SHORT).show();
        }
    }
}


