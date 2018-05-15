package com.mycompany.myjiemian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class richenbiao extends AppCompatActivity implements View.OnClickListener{
    private Button cbt;
    private Button fbt;
    private Button bbt;
    public MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("日程表");
        setContentView(R.layout.activity_richenbiao);
        dbHelper = new MyDatabaseHelper(this,"Event.db",null,1);
        find_and_modify_button();
    }

    private void find_and_modify_button() {
     cbt = (Button) findViewById(R.id.create_button);
        cbt.setOnClickListener(this);
     fbt = (Button) findViewById(R.id.future_button);
        fbt.setOnClickListener(this);
        bbt=(Button) findViewById(R.id.back);
        bbt.setOnClickListener(this);
    }


    public void onClick(View v){
               switch (v.getId()){
                   case R.id.create_button:
                       dbHelper.getWritableDatabase();
                    gotocreate();
                       break;
                   case R.id.future_button:
                       gotofuture();
                       break;
                   case R.id.back:
                       goback();
                       break;
                 }
    }


    private void gotocreate(){
        Intent intent = new Intent();
        intent.setClass(richenbiao.this,create_activity.class);
        startActivity(intent);
    }

    private void gotofuture(){
        Intent intent = new Intent();
        intent.setClass(richenbiao.this,future.class);
        startActivity(intent);
    }
    private void goback(){
        Intent intent = new Intent();
        intent.setClass(richenbiao.this,MainActivity.class);
        startActivity(intent);
    }
}
