package com.mycompany.myjiemian;



/**
 * Created by CIce on 2017/11/13.
 */
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

public class CTdata extends SQLiteOpenHelper {
    public static final String COURSEIN = "create table courseinfo("+
            "cdept varchar(50)" +
            "cno varchar(30)," +
            "cname varchar(100)," +
            "ccredit varchar(30)," +
            "tname varchar(100)," +
            "cweek varchar(50)," +
            "cday varchar(50)," +
            "ctime varchar(50)," +
            "ccampus varchar(50)," +
            "cbuilding varchar(30)," +
            "cclassroom varchar(30)," +
            "ccap varchar(30)," +
            "csnum varchar(30)," +
            " primary key(cno,tname,cweek,cday,ctime,cbuilding,cclassroom,ccampus,ccap,csnum,cdept,cname));";

    public CTdata(Context context) {
        super(context, "course.db", null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COURSEIN);
       db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","李欣*","3-18周上","3","1~2","江安","艺术大楼","形体1","53","16"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","李欣*","3-18周上","4","3~4","江安","艺术大楼","形体2","53","16"});
      //  db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","李欣*","3-18周上","1","3~4","江安","艺术大楼","形体2","53","16"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","李欣*","3-18周上","2","1~2","江安","艺术大楼","形体2","53","16"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","唐琳佳*","3-18周上","2","1~2","江安","艺术大楼","形体1","53","20"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","唐琳佳*","3-18周上","5","1~2","江安","艺术大楼","形体3","53","20"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","唐琳佳*","3-18周上","4","1~2","江安","艺术大楼","形体3","53","20"});
       // db.execSQL("insert  into courseinfo(cdept,cno,cname,ccredit,tname,cweek,cday,ctime,ccampus,cbuilding,cclassroom,ccap,csnum ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new String[] {"艺术学院","101003050","芭蕾舞基本功训练-1","5.0","唐琳佳*","3-18周上","3","1~2","江安","艺术大楼","形体2","53","20"});
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        //arg0.execSQL("DROP TABLE IF EXISTS "+"courseinfo");
       // onCreate(arg0);
    }
}