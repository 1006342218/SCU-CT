package com.mycompany.myjiemian;

/**
 * Created by 647 on 2017/11/29.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MyDatabaseHelper extends SQLiteOpenHelper {
 public static final String DATA="create table Event("
                                    +"events text,"
                                    +"time text,"
                                    +"year   int,"
                                    +"month int,"
                                    +"day int,"
                                    +"hour int,"
                                    +"minute int)";
private Context mContext;
    public MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context, name, factory, version);
        mContext=context;
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATA);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
        db.execSQL("drop table if exists Event");
        onCreate(db);

    }
}
