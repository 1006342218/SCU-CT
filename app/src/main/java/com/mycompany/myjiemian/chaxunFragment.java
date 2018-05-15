package com.mycompany.myjiemian;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;


import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ListIterator;

import static com.mycompany.myjiemian.R.id.all;
import static com.mycompany.myjiemian.R.id.imageView;
import static com.mycompany.myjiemian.R.id.keyword;
import static com.mycompany.myjiemian.R.id.my_chaxun;



public class chaxunFragment extends Fragment {
    private ImageButton btn;
    private EditText ed;
    private String keyword;
    private LinearLayout cx;
    String[] xinxi= {"学院:\"艺术学院\"\n课程号:\"101003050\"\n课程名:\"芭蕾舞基本功训练-1\"\n学分:\"5.0\"\n教师:\"李欣\"\n周次:\"3-18周上\"\n星期:\"3\"\n节次:\"1~2\n\"校区:\"江安\"\n教学楼:\"艺术大楼\"\n教师:\"形体1\"\n课余量:\"53\"\n\"学生数:16\"",
            "\"学院名:外国语学院\"\n" + "\"\"课程号:105395020\"\n" + "\"\"课程名:大学英语（创意阅读）-3\"\n" + "\"\"学分:2.0\"\n" + "\"\"老师名:白昊*\"\n" + "\"\"上课周次:1-17周\"\n" + "\"\"星期:3\"\n" + "\"\"节次:1~2\"\n" + "\"\"校区:江安\"\n" + "\"\"教学楼:一教D座\"\n" + "\"\"教室:D204\"\n" + "\"\"课余量:49\"\n" + "\"\"学生数:76\"" ,
            "学院名:\"水利水电学院\"\n课程号:\"306116020\"\n" + "课程名:\"岩石力学\"\n" + "学分:\"2.0\"\n" + "老师名:\"谢红强* 戴峰\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"1\"\n" + "节次:\"3~4\"\n" + "校区:\"望江\"\n" + "教学楼:\"基教楼A座\"\n" + "教室:\"A408\"\n" + "课余量:\"88\"\n" + "学生数:\"74\"",
            "学院名:\"水利水电学院\"\n课程号:\"306116020\"\n" + "课程名:\"岩石力学\"\n" + "学分:\"2.0\"\n" + "老师名:\"谢红强* 戴峰\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"1\"\n" + "节次:\"3~4\"\n" + "校区:\"望江\"\n" + "教学楼:\"基教楼A座\"\n" + "教室:\"A408\"\n" + "课余量:\"88\"\n" + "学生数:\"74\"" ,
            "学院名:\"计算机学院\"\n课程号:\"304202010\"\n" + "课程名:\"数字逻辑实验\"\n" + "学分:\"1.0\"\n" + "老师名:\"潘薇*\"\n" + "上课周次:\"6-13周上\"\n" + "星期:\"3\"\n" + "节次:\"3~4\"\n" + "校区:\"江安\"\n" + "教学楼:\"实验室\"\n" + "教室:\"二基楼B305\"\n" + "课余量:\"78\"\n" + "学生数:\"70\"" ,
            "学院名:\"计算机学院\"\n课程号:\"304201020\"\n" + "课程名:\"计算机导论\"\n" + "学分:\"2.0\"\n" + "老师名:\"吴志红*\"\n" + "上课周次:\"3-18周上\"\n" + "星期:\"3\"\n" + "节次:\"5~6\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教D座\"\n" + "教室:\"D402\"\n" + "课余量:\"86\"\n" + "学生数:\"55\"" ,
            "学院名:\"计算机学院\"\n课程号:\"304193020\"\n" + "课程名:\"互联网技术视角下的创新创业实践\"\n" + "学分:\"2.0\"\n" + "老师名:\"黄彦辉*\"\n" + "上课周次:\"3-18周上\"\n" + "星期:\"5\"\n" + "节次:\"3~4\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A518\"\n" + "课余量:\"60\"\n" + "学生数:\"16\"",
            "学院名:\"计算机学院\"\n课程号:\"304174010\"\n" + "课程名:\"大数据引论\"\n" + "学分:\"1.0\"\n" + "老师名:\"吕建成*\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"5\"\n" + "节次:\"3~4\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A410\"\n" + "课余量:\"50\"\n" + "学生数:\"36\"" ,
            "学院名:\"计算机学院\"\n课程号:\"304160010\"\n" +"课程名:\"数据分析的机器智能方法\"\n" + "学分:\"1.0\"\n" + "老师名:\"彭德中*\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"1\"\n" + "节次:\"8~9\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A316\"\n" + "课余量:\"80\"\n" + "学生数:\"48\"",
            "学院名:\"计算机学院\"\n课程号:\"304159010\"\n" + "课程名:\"表达学习\"\n" + "学分:\"1.0\"\n" + "老师名:\"张蕾*\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"3\"\n" + "节次:\"1~2\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A301\"\n" + "课余量:\"80\"\n" + "学生数:\"77\"",
            "学院名:\"计算机学院\"\n课程号:\"304158010\"\n" + "课程名:\"深度学习引论\"\n" + "学分:\"1.0\"\n" + "老师名:\"章毅*\"\n" + "上课周次:\"1-8周上\"\n" + "星期:\"4\"\n" + "节次:\"5~6\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教D座\"\n" + "教室:\"D403\"\n" + "课余量:\"30\"\n" + "学生数:\"24\"",
            "学院名:\"计算机学院\"\n课程号:\"304157050\"\n" + "课程名:\"离散数学（双语）\"\n" + "学分:\"5.0\"\n" + "老师名:\"冯伟森*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"4\"\n" + "节次:\"5~7\"\n" + "校区:\"江安\"\n" + "教学楼:\"文科楼二区\"\n" + "教室:\"223\"\n" + "课余量:\"30\"\n" + "学生数:\"15\"",
            "学院名:\"计算机学院\"\n课程号:\"304156050\"\n" + "课程名:\"离散数学\"\n" + "学分:\"5.0\"\n" + "老师名:\"陈瑜*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"3\"\n" + "节次:\"1~2\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A106\"\n" + "课余量:\"80\"\n" + "学生数:\"80\"",
            "学院名:\"计算机学院\"\n课程号:\"304156050\"\n" + "课程名:\"离散数学\"\n" + "学分:\"5.0\"\n" + "老师名:\"代术成*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"3\"\n" + "节次:\"5~7\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A308\"\n" + "课余量:\"80\"\n" + "学生数:\"50\"",
            "学院名:\"计算机学院\"\n课程号:\"304154030\"\n" + "课程名:\"现代软件工程（项目开发管理）\"\n" + "学分:\"3.0\"\n" + "老师名:\"周欣*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"2\"\n" + "节次:\"5~7\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A403\"\n" + "课余量:\"80\"\n" + "学生数:\"28\"",
            "学院名:\"计算机学院\"\n课程号:\"304152020\"\n" + "课程名:\"UNIX操作系统\"\n" + "学分:\"2.0\"\n" + "老师名:\"刘一静*\"\n" + "上课周次:\"3-18周上\"\n" + "星期:\"5\"\n" + "节次:\"5~6\"\n" + "校区:\"江安\"\n" + "教学楼:\"实验室\"\n" + "教室:\"二基楼B304\"\n" + "课余量:\"98\"\n" + "学生数:\"103\"",
            "学院名:\"计算机学院\"\n课程号:\"304138030\"\n" + "课程名:\"数据库系统原理（双语）\"\n" + "学分:\"3.0\"\n" + "老师名:\"段磊*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"3\"\n" + "节次:\"5~7\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A208\"\n" + "课余量:\"40\"\n" + "学生数:\"10\"",
            "学院名:\"计算机学院\"\n课程号:\"304065010\"\n" + "课程名:\"现代软件工程课程设计\"\n" + "学分:\"1.0\"\n" + "老师名:\"罗以宁*\"\n" + "上课周次:\"6-16周上\"\n" + "星期:\"2\"\n" + "节次:\"8~9\"\n" + "校区:\"江安\"\n" + "教学楼:\"实验室\"\n" + "教室:\"二基楼B303\"\n" + "课余量:\"80\"\n" + "学生数:\"46\"",
            "学院名:\"计算机学院\"\n课程号:\"304064030\"\n" + "课程名:\"现代软件工程（双语）\"\n" + "学分:\"3.0\"\n" + "老师名:\"罗以宁*\"\n" + "上课周次:\"1-17周\"\n" + "星期:\"2\"\n" + "节次:\"1~3\"\n" + "校区:\"江安\"\n" + "教学楼:\"一教A座\"\n" + "教室:\"A610\"\n" + "课余量:\"80\"\n" + "学生数:\"45\"",
            "学院名:\"计算机学院\"\n课程号:\"304061010\"\n" + "课程名:\"微机系统与接口技术实验\"\n" + "学分:\"1.0\"\n" + "老师名:\"李勤*\"\n" +"上课周次:\"11-15周上\"\n" + "星期:\"1\"\n" + "节次:\"1~4\"\n" + "校区:\"江安\"\n" + "教学楼:\"实验室\"\n" + "教室:\"二基楼B310B\"\n" + "课余量:\"80\"\n" + "学生数:\"67\"",
    };




    public chaxunFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chaxun, container, false);
        btn = (ImageButton) view.findViewById(R.id.imageButton2);
        ed = (EditText) view.findViewById(R.id.keyword);
        cx = (LinearLayout) view.findViewById(R.id.my_chaxun);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //重新设置按下时的背景图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable((R.drawable.ic_action_sosotubiao0)));
                    TextView tv = new TextView(getActivity());
                    tv.setText(null);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //再修改为抬起时的正常图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.ic_action_sosuotubiao));
                    String  result="查询结果:";
                    keyword = ed.getText().toString();
                    TextView tv = new TextView(getActivity());
                    int []j=Key.isIn(keyword, xinxi);
                    for(int i=0;i<j.length;i++)
                    {
                        if (j[i] >0)
                        {
                            result=result+"\n\n"+xinxi[i];
                        }
                    }
                    if(result!="查询结果:"){
                        tv.setText(result);
                        tv.setTextSize(18);
                        cx.addView(tv);
                    }
                    else {
                        Toast.makeText(getActivity(), "不存在课程", Toast.LENGTH_SHORT).show();
                    }
                }

                return false;
            }

        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

}


