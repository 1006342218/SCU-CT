package com.mycompany.myjiemian;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import com.mycompany.myjiemian.dbHelper;
import com.mycompany.myjiemian.R;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static android.R.attr.bottom;
import static android.R.attr.data;
import static android.R.attr.top;


public class kebiao extends Fragment {

    private TextView tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    private static TextView class11,class12,class13,class14,class15,class16,class17;
    private static TextView class21,class22,class23,class24,class25,class26,class27;
    private static TextView class31,class32,class33,class34,class35,class36,class37;
    private static TextView class41,class42,class43,class44,class45,class46,class47;
    private static TextView class51,class52,class53,class54,class55,class56,class57;
    private static TextView class61,class62,class63,class64,class65,class66,class67;
    private static TextView class71,class72,class73,class74,class75,class76,class77;
    private static TextView class81,class82,class83,class84,class85,class86,class87;
    private static TextView class91,class92,class93,class94,class95,class96,class97;
    private static TextView class101,class102,class103,class104,class105,class106,class107;
    private static TextView class111,class112,class113,class114,class115,class116,class117;
    private static TextView class121,class122,class123,class124,class125,class126,class127;
    private static  final int HASCRAWLCT=1;
    private static  String[][] useKebiao;
    private Button bt;


    private static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==HASCRAWLCT){
                String[][] temp=(String[][])msg.obj;

                if(temp[1][1]!=null){
                    int x=1;
                    int i;
                    if(temp[2][1]!=null&&temp[1][1].equals(temp[2][1])){
                        x++;
                        if(temp[3][1]!=null&&temp[1][1].equals(temp[3][1])){
                            x++;
                            if(temp[4][1]!=null&&temp[1][1].equals(temp[4][1])){
                                x++;
                                i=temp[1][1].length();
                                int j=i/x;
                                String s=temp[1][1].substring(0, j);
                                String s1= temp[1][1].substring(j,(2*j) );
                                String s2= temp[1][1].substring((2*j),(3*j));
                                String s3= temp[1][1].substring((3*j),i );
                                class11.setText(s);
                                class21.setText(s1);
                                class31.setText(s2);
                                class41.setText(s3);
                            }
                            else {
                                i=temp[1][1].length();
                                int j=i/x;
                                String s=temp[1][1].substring(0, j);
                                String s1= temp[1][1].substring(j,(2*j) );
                                String s2= temp[1][1].substring((2*j),i);
                                class11.setText(s);
                                class21.setText(s1);
                                class31.setText(s2);
                            }
                        }
                        else {
                            i=temp[1][1].length();
                            int j=i/x;
                            String s=temp[1][1].substring(0, j);
                            String s1= temp[1][1].substring(j,(2*j) );
                            class11.setText(s);
                            class21.setText(s1);

                        }
                    }
                    else {
                        class11.setText(temp[1][1]);
                    }
                }     //1-1to4



                if(temp[1][2]!=null){
                    int x=1;
                    int i;
                    if(temp[2][2]!=null&&temp[1][2].equals(temp[2][2])){
                        x++;
                        if(temp[3][2]!=null&&temp[1][2].equals(temp[3][2])){
                            x++;
                            if(temp[4][2]!=null&&temp[1][2].equals(temp[4][2])){
                                x++;
                                i=temp[1][2].length();
                                int j=i/x;
                                String s=temp[1][2].substring(0, j);
                                String s1= temp[1][2].substring(j,(2*j) );
                                String s2= temp[1][2].substring((2*j),(3*j));
                                String s3= temp[1][2].substring((3*j),i );
                                class12.setText(s);
                                class22.setText(s1);
                                class32.setText(s2);
                                class42.setText(s3);
                            }
                            else {
                                i=temp[1][2].length();
                                int j=i/x;
                                String s=temp[1][2].substring(0, j);
                                String s1= temp[1][2].substring(j,(2*j) );
                                String s2= temp[1][2].substring((2*j),i);
                                class12.setText(s);
                                class22.setText(s1);
                                class32.setText(s2);
                            }
                        }
                        else {
                            i=temp[1][2].length();
                            int j=i/x;
                            String s=temp[1][2].substring(0, j);
                            String s1= temp[1][2].substring(j,i);
                            class12.setText(s);
                            class22.setText(s1);
                        }
                    }
                    else {
                        class12.setText(temp[1][2]);
                    }
                }     //2-4


                if(temp[1][3]!=null){
                    int x=1;
                    int i;
                    if(temp[2][3]!=null&&temp[1][3].equals(temp[2][3])){
                        x++;
                        if(temp[3][3]!=null&&temp[1][3].equals(temp[3][3])){
                            x++;
                            if(temp[4][3]!=null&&temp[1][3].equals(temp[4][3])){
                                x++;
                                i=temp[1][3].length();
                                int j=i/x;
                                String s=temp[1][3].substring(0, j);
                                String s1= temp[1][3].substring(j,(2*j) );
                                String s2= temp[1][3].substring((2*j),(3*j));
                                String s3= temp[1][3].substring((3*j),i );
                                class13.setText(s);
                                class23.setText(s1);
                                class33.setText(s2);
                                class43.setText(s3);
                            }
                            else {
                                i=temp[1][3].length();
                                int j=i/x;
                                String s=temp[1][3].substring(0, j);
                                String s1= temp[1][3].substring(j,(2*j) );
                                String s2= temp[1][3].substring((2*j),i);
                                class13.setText(s);
                                class23.setText(s1);
                                class33.setText(s2);
                            }
                        }
                        else {
                            i=temp[1][3].length();
                            int j=i/x;
                            String s=temp[1][3].substring(0, j);
                            String s1= temp[1][3].substring(j,i );
                            class13.setText(s);
                            class23.setText(s1);
                        }
                    }
                    else {
                        class15.setText(temp[1][3]);
                    }
                }     //3-4



                if(temp[1][4]!=null){
                    int x=1;
                    int i;
                    if(temp[2][4]!=null&&temp[1][4].equals(temp[2][4])){
                        x++;
                        if(temp[3][4]!=null&&temp[1][4].equals(temp[3][4])){
                            x++;
                            if(temp[4][4]!=null&&temp[1][4].equals(temp[4][4])){
                                x++;
                                i=temp[1][4].length();
                                int j=i/x;
                                String s=temp[1][4].substring(0, j);
                                String s1= temp[1][4].substring(j,(2*j) );
                                String s2= temp[1][4].substring((2*j),(3*j));
                                String s3= temp[1][4].substring((3*j),i );
                                class14.setText(s);
                                class24.setText(s1);
                                class34.setText(s2);
                                class44.setText(s3);
                            }
                            else {
                                i=temp[1][4].length();
                                int j=i/x;
                                String s=temp[1][4].substring(0, j);
                                String s1= temp[1][4].substring(j,(2*j) );
                                String s2= temp[1][4].substring((2*j),i);
                                class14.setText(s);
                                class24.setText(s1);
                                class34.setText(s2);
                            }
                        }
                        else {
                            i=temp[1][4].length();
                            int j=i/x;
                            String s=temp[1][4].substring(0, j);
                            String s1= temp[1][4].substring(j,(2*j) );
                            class14.setText(s);
                            class24.setText(s1);


                        }
                    }
                    else {
                        class14.setText(temp[1][4]);
                    }
                }     //4-4



                if(temp[1][5]!=null){
                    int x=1;
                    int i;
                    if(temp[2][5]!=null&&temp[1][5].equals(temp[2][5])){
                        x++;
                        if(temp[3][5]!=null&&temp[1][5].equals(temp[3][5])){
                            x++;
                            if(temp[4][5]!=null&&temp[1][5].equals(temp[4][5])){
                                x++;
                                i=temp[1][5].length();
                                int j=i/x;
                                String s=temp[1][5].substring(0, j);
                                String s1= temp[1][5].substring(j,(2*j) );
                                String s2= temp[1][5].substring((2*j),(3*j));
                                String s3= temp[1][5].substring((3*j),i );
                                class15.setText(s);
                                class25.setText(s1);
                                class35.setText(s2);
                                class45.setText(s3);
                            }
                            else {
                                i=temp[1][5].length();
                                int j=i/x;
                                String s=temp[1][5].substring(0, j);
                                String s1= temp[1][5].substring(j,(2*j) );
                                String s2= temp[1][5].substring((2*j),i);
                                class15.setText(s);
                                class25.setText(s1);
                                class35.setText(s2);
                            }
                        }
                        else {
                            i=temp[1][5].length();
                            int j=i/x;
                            String s=temp[1][5].substring(0, j);
                            String s1= temp[1][5].substring(j,i );
                            class15.setText(s);
                            class25.setText(s1);

                        }
                    }
                    else {
                        class15.setText(temp[1][5]);
                    }
                }     //5-4

                if(temp[3][1].equals(temp[2][1]))
                {}
                    else {
                    int x=1;
                    int i;
                    if(temp[3][1].equals(temp[4][1])){
                        x++;
                        i=temp[3][1].length();
                        int j=i/x;
                        String s=temp[3][1].substring(0, j);
                        String s1= temp[3][1].substring(j,i);
                        class31.setText(s);
                        class41.setText(s1);
                    }
                    else {
                        class31.setText(temp[3][1]);
                    }
                }//1-34



                if(temp[3][2].equals(temp[2][2]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[3][2].equals(temp[4][2])){
                        x++;
                        i=temp[3][2].length();
                        int j=i/x;
                        String s=temp[3][2].substring(0, j);
                        String s1= temp[3][2].substring(j,i);
                        class32.setText(s);
                        class42.setText(s1);
                    }
                    else {
                        class32.setText(temp[3][2]);
                    }
                }//2-34

                if(temp[3][3].equals(temp[2][3]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[3][3].equals(temp[4][3])){
                        x++;
                        i=temp[3][3].length();
                        int j=i/x;
                        String s=temp[3][3].substring(0, j);
                        String s1= temp[3][3].substring(j,i);
                        class33.setText(s);
                        class43.setText(s1);
                    }
                    else {
                        class33.setText(temp[3][3]);
                    }
                }//3-34


                if(temp[3][4].equals(temp[2][4]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[3][4].equals(temp[4][4])){
                        x++;
                        i=temp[3][4].length();
                        int j=i/x;
                        String s=temp[3][4].substring(0, j);
                        String s1= temp[3][4].substring(j,i);
                        class34.setText(s);
                        class44.setText(s1);
                    }
                    else {
                        class34.setText(temp[3][4]);
                    }
                }//4-34


                if(temp[3][5].equals(temp[2][5]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[3][5].equals(temp[4][5])){
                        x++;
                        i=temp[3][5].length();
                        int j=i/x;
                        String s=temp[3][5].substring(0, j);
                        String s1= temp[3][5].substring(j,i);
                        class35.setText(s);
                        class45.setText(s1);
                    }
                    else {
                        class35.setText(temp[3][5]);
                    }
                }//5-34


                /////////上午课

                if(temp[6][1]!=null){
                    int x=1;
                    int i;
                    if(temp[7][1]!=null&&temp[6][1].equals(temp[7][1])){
                        x++;
                        if(temp[8][1]!=null&&temp[6][1].equals(temp[8][1])){
                            x++;
                            if(temp[9][1]!=null&&temp[6][1].equals(temp[9][1])){
                                x++;
                                if(temp[10][1]!=null&&temp[6][1].equals(temp[10][1]))
                                {
                                    i = temp[6][1].length();
                                    int j = i / x;
                                    String s = temp[6][1].substring(0, j);
                                    String s1 = temp[6][1].substring(j, (2 * j));
                                    String s2 = temp[6][1].substring((2 * j), (3 * j));
                                    String s3 = temp[6][1].substring((3 * j), (4 * j));
                                    String s4 = temp[6][1].substring((4 * j), i);
                                    class51.setText(s);
                                    class61.setText(s1);
                                    class71.setText(s2);
                                    class81.setText(s3);
                                    class91.setText(s4);
                                }
                                else {
                                    i = temp[6][1].length();
                                    int j = i / x;
                                    String s = temp[6][1].substring(0, j);
                                    String s1 = temp[6][1].substring(j, (2 * j));
                                    String s2 = temp[6][1].substring((2 * j), (3 * j));
                                    String s3 = temp[6][1].substring((3 * j), i);
                                    class51.setText(s);
                                    class61.setText(s1);
                                    class71.setText(s2);
                                    class81.setText(s3);
                                }
                            }
                            else {
                                i=temp[6][1].length();
                                int j=i/x;
                                String s=temp[6][1].substring(0, j);
                                String s1= temp[6][1].substring(j,(2*j) );
                                String s2= temp[6][1].substring((2*j),i);
                                class51.setText(s);
                                class61.setText(s1);
                                class71.setText(s2);
                            }
                        }
                        else {
                            i=temp[6][1].length();
                            int j=i/x;
                            String s=temp[6][1].substring(0, j);
                            String s1= temp[6][1].substring(j,i );
                            class51.setText(s);
                            class61.setText(s1);

                        }
                    }
                    else {
                        class52.setText(temp[6][1]);
                    }
                }     //1-6to10

                if(temp[6][2]!=null){
                    int x=1;
                    int i;
                    if(temp[7][2]!=null&&temp[6][2].equals(temp[7][2])){
                        x++;
                        if(temp[8][2]!=null&&temp[6][2].equals(temp[8][2])){
                            x++;
                            if(temp[9][2]!=null&&temp[6][2].equals(temp[9][2])){
                                x++;
                                if(temp[10][2]!=null&&temp[6][2].equals(temp[10][2]))
                                {
                                    i = temp[6][2].length();
                                    int j = i / x;
                                    String s = temp[6][2].substring(0, j);
                                    String s1 = temp[6][2].substring(j, (2 * j));
                                    String s2 = temp[6][2].substring((2 * j), (3 * j));
                                    String s3 = temp[6][2].substring((3 * j), (4 * j));
                                    String s4 = temp[6][2].substring((4 * j), i);
                                    class52.setText(s);
                                    class62.setText(s1);
                                    class72.setText(s2);
                                    class82.setText(s3);
                                    class92.setText(s4);
                                }
                                else {
                                    i = temp[6][2].length();
                                    int j = i / x;
                                    String s = temp[6][2].substring(0, j);
                                    String s1 = temp[6][2].substring(j, (2 * j));
                                    String s2 = temp[6][2].substring((2 * j), (3 * j));
                                    String s3 = temp[6][2].substring((3 * j), i);
                                    class52.setText(s);
                                    class62.setText(s1);
                                    class72.setText(s2);
                                    class82.setText(s3);
                                }
                            }
                            else {
                                i=temp[6][2].length();
                                int j=i/x;
                                String s=temp[6][2].substring(0, j);
                                String s1= temp[6][2].substring(j,(2*j) );
                                String s2= temp[6][2].substring((2*j),i);
                                class52.setText(s);
                                class62.setText(s1);
                                class72.setText(s2);
                            }
                        }
                        else {
                            i=temp[6][2].length();
                            int j=i/x;
                            String s=temp[6][2].substring(0, j);
                            String s1= temp[6][2].substring(j,i );
                            class52.setText(s);
                            class62.setText(s1);

                        }
                    }
                    else {
                        class52.setText(temp[6][2]);
                    }
                }     //2-6to10



                if(temp[6][3]!=null){
                    int x=1;
                    int i;
                    if(temp[7][3]!=null&&temp[6][3].equals(temp[7][3])){
                        x++;
                        if(temp[8][3]!=null&&temp[6][3].equals(temp[8][3])){
                            x++;
                            if(temp[9][3]!=null&&temp[6][3].equals(temp[9][3])){
                                x++;
                                if(temp[10][3]!=null&&temp[6][3].equals(temp[10][3]))
                                {
                                    i = temp[6][3].length();
                                    int j = i / x;
                                    String s = temp[6][3].substring(0, j);
                                    String s1 = temp[6][3].substring(j, (2 * j));
                                    String s2 = temp[6][3].substring((2 * j), (3 * j));
                                    String s3 = temp[6][3].substring((3 * j), (4 * j));
                                    String s4 = temp[6][3].substring((4 * j), i);
                                    class53.setText(s);
                                    class63.setText(s1);
                                    class73.setText(s2);
                                    class83.setText(s3);
                                    class93.setText(s4);
                                }
                                else {
                                    i = temp[6][3].length();
                                    int j = i / x;
                                    String s = temp[6][3].substring(0, j);
                                    String s1 = temp[6][3].substring(j, (2 * j));
                                    String s2 = temp[6][3].substring((2 * j), (3 * j));
                                    String s3 = temp[6][3].substring((3 * j), i);
                                    class53.setText(s);
                                    class63.setText(s1);
                                    class73.setText(s2);
                                    class83.setText(s3);
                                }
                            }
                            else {
                                i=temp[6][3].length();
                                int j=i/x;
                                String s=temp[6][3].substring(0, j);
                                String s1= temp[6][3].substring(j,(2*j) );
                                String s2= temp[6][3].substring((2*j),i);
                                class53.setText(s);
                                class63.setText(s1);
                                class73.setText(s2);
                            }
                        }
                        else {
                            i=temp[6][3].length();
                            int j=i/x;
                            String s=temp[6][3].substring(0, j);
                            String s1= temp[6][3].substring(j,i );
                            class53.setText(s);
                            class63.setText(s1);

                        }
                    }
                    else {
                        class53.setText(temp[6][3]);
                    }
                }     //3-6to10

                if(temp[6][4]!=null){
                    int x=1;
                    int i;
                    if(temp[7][4]!=null&&temp[6][4].equals(temp[7][4])){
                        x++;
                        if(temp[8][4]!=null&&temp[6][4].equals(temp[8][4])){
                            x++;
                            if(temp[9][4]!=null&&temp[6][4].equals(temp[9][4])){
                                x++;
                                if(temp[10][4]!=null&&temp[6][4].equals(temp[10][4]))
                                {
                                    i = temp[6][4].length();
                                    int j = i / x;
                                    String s = temp[6][4].substring(0, j);
                                    String s1 = temp[6][4].substring(j, (2 * j));
                                    String s2 = temp[6][4].substring((2 * j), (3 * j));
                                    String s3 = temp[6][4].substring((3 * j), (4 * j));
                                    String s4 = temp[6][4].substring((4 * j), i);
                                    class54.setText(s);
                                    class64.setText(s1);
                                    class74.setText(s2);
                                    class84.setText(s3);
                                    class94.setText(s4);
                                }
                                else {
                                    i = temp[6][4].length();
                                    int j = i / x;
                                    String s = temp[6][4].substring(0, j);
                                    String s1 = temp[6][4].substring(j, (2 * j));
                                    String s2 = temp[6][4].substring((2 * j), (3 * j));
                                    String s3 = temp[6][4].substring((3 * j), i);
                                    class54.setText(s);
                                    class64.setText(s1);
                                    class74.setText(s2);
                                    class84.setText(s3);
                                }
                            }
                            else {
                                i=temp[6][4].length();
                                int j=i/x;
                                String s=temp[6][4].substring(0,j);
                                String s1= temp[6][4].substring(j,(2*j));
                                String s2= temp[6][4].substring((2*j),i);
                                class54.setText(s);
                                class64.setText(s1);
                                class74.setText(s2);
                            }
                        }
                        else {
                            i=temp[6][4].length();
                            int j=i/x;
                            String s=temp[6][4].substring(0, j);
                            String s1= temp[6][4].substring(j,i );
                            class54.setText(s);
                            class64.setText(s1);
                        }
                    }
                    else {
                        class54.setText(temp[6][4]);
                    }
                }     //4-6to10



                if(temp[6][5]!=null){
                    int x=1;
                    int i;
                    if(temp[7][5]!=null&&temp[6][5].equals(temp[7][5])){
                        x++;
                        if(temp[8][5]!=null&&temp[6][5].equals(temp[8][5])){
                            x++;
                            if(temp[9][5]!=null&&temp[6][5].equals(temp[9][5])){
                                x++;
                                if(temp[10][5]!=null&&temp[6][5].equals(temp[10][5]))
                                {
                                    i = temp[6][5].length();
                                    int j = i / x;
                                    String s = temp[6][5].substring(0, j);
                                    String s1 = temp[6][5].substring(j, (2 * j));
                                    String s2 = temp[6][5].substring((2 * j), (3 * j));
                                    String s3 = temp[6][5].substring((3 * j), (4 * j));
                                    String s4 = temp[6][5].substring((4 * j), i);
                                    class55.setText(s);
                                    class65.setText(s1);
                                    class75.setText(s2);
                                    class85.setText(s3);
                                    class95.setText(s4);
                                }
                                else {
                                    i = temp[6][5].length();
                                    int j = i / x;
                                    String s = temp[6][5].substring(0, j);
                                    String s1 = temp[6][5].substring(j, (2 * j));
                                    String s2 = temp[6][5].substring((2 * j), (3 * j));
                                    String s3 = temp[6][5].substring((3 * j), i);
                                    class55.setText(s);
                                    class65.setText(s1);
                                    class75.setText(s2);
                                    class85.setText(s3);
                                }
                            }
                            else {
                                i=temp[6][5].length();
                                int j=i/x;
                                String s=temp[6][5].substring(0, j);
                                String s1= temp[6][5].substring(j,(2*j) );
                                String s2= temp[6][5].substring((2*j),i);
                                class55.setText(s);
                                class65.setText(s1);
                                class75.setText(s2);
                            }
                        }
                        else {
                            i=temp[6][5].length();
                            int j=i/x;
                            String s=temp[6][5].substring(0, j);
                            String s1= temp[6][5].substring(j,i );
                            class55.setText(s);
                            class65.setText(s1);

                        }
                    }
                    else {
                        class55.setText(temp[6][5]);
                    }
                }     //5-6to10


                if(temp[8][1].equals(temp[9][1]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[9][1].equals(temp[10][1])){
                        x++;
                        i=temp[9][1].length();
                        int j=i/x;
                        String s=temp[9][1].substring(0, j);
                        String s1= temp[9][1].substring(j,i);
                        class81.setText(s);
                        class91.setText(s1);
                    }
                    else {
                        class81.setText(temp[9][1]);
                    }
                }//1-9to10

                if(temp[8][2].equals(temp[9][2]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[9][2].equals(temp[10][2])){
                        x++;
                        i=temp[9][2].length();
                        int j=i/x;
                        String s=temp[9][2].substring(0, j);
                        String s1= temp[9][2].substring(j,i);
                        class82.setText(s);
                        class92.setText(s1);
                    }
                    else {
                        class82.setText(temp[9][2]);
                    }
                }//2-9to10


                if(temp[8][3].equals(temp[9][3]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[9][3].equals(temp[10][3])){
                        x++;
                        i=temp[9][3].length();
                        int j=i/x;
                        String s=temp[9][3].substring(0, j);
                        String s1= temp[9][3].substring(j,i);
                        class83.setText(s);
                        class93.setText(s1);
                    }
                    else {
                        class83.setText(temp[9][3]);
                    }
                }//3-9to10

                if(temp[8][4].equals(temp[9][4]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[9][4].equals(temp[10][4])){
                        x++;
                        i=temp[9][4].length();
                        int j=i/x;
                        String s=temp[9][4].substring(0, j);
                        String s1= temp[9][4].substring(j,(2*j));
                        class84.setText(s);
                        class94.setText(s1);
                    }
                    else {
                        class84.setText(temp[9][4]);
                    }
                }//4-9to10

                if(temp[8][5].equals(temp[9][5]))
                {}
                else {
                    int x=1;
                    int i;
                    if(temp[9][5].equals(temp[10][5])){
                        x++;
                        i=temp[9][5].length();
                        int j=i/x;
                        String s=temp[9][5].substring(0, j);
                        String s1= temp[9][5].substring(j,(2*j));
                        class85.setText(s);
                        class95.setText(s1);
                    }
                    else {
                        class85.setText(temp[9][5]);
                    }
                }//5-9to10

                           /////以上下午课

                if(temp[12][1].equals(null))
                {}
                else {
                    int x = 1;
                    int i;
                    if (temp[12][1].equals(temp[13][1])) {
                        x++;
                        if (temp[13][1].equals(temp[14][1])) {
                            x++;
                            i = temp[12][1].length();
                            int j = i / x;
                            String s = temp[12][1].substring(0, j);
                            String s1 = temp[12][1].substring(j, (2 * j));
                            String s2 = temp[12][1].substring((2 * j), i);
                            class101.setText(s);
                            class111.setText(s1);
                            class121.setText(s2);
                        }
                        else {
                            i = temp[12][1].length();
                            int j = i / x;
                            String s = temp[12][1].substring(0, j);
                            String s1 = temp[12][1].substring(j, i);

                            class101.setText(s);
                            class111.setText(s1);

                        }
                    }
                    else {
                        class101.setText(temp[12][1]);
                    }
                }
                //1-10to12


                if(temp[12][2].equals(null))
                {}
                else {
                    int x = 1;
                    int i;
                    if (temp[12][2].equals(temp[13][2])) {
                        x++;
                        if (temp[13][2].equals(temp[14][2])) {
                            x++;
                            i = temp[12][2].length();
                            int j = i / x;
                            String s = temp[12][2].substring(0, j);
                            String s1 = temp[12][2].substring(j, (2 * j));
                            String s2 = temp[12][2].substring((2 * j), i);
                            class102.setText(s);
                            class112.setText(s1);
                            class122.setText(s2);
                        }
                        else {
                            i = temp[12][2].length();
                            int j = i / x;
                            String s = temp[12][2].substring(0, j);
                            String s1 = temp[12][2].substring(j, i);

                            class102.setText(s);
                            class112.setText(s1);

                        }
                    }
                    else {
                        class102.setText(temp[12][2]);
                    }
                }
                //2-10to12


                if(temp[12][3].equals(null))
                {}
                else {
                    int x = 1;
                    int i;
                    if (temp[12][3].equals(temp[13][3])) {
                        x++;
                        if (temp[13][3].equals(temp[14][3])) {
                            x++;
                            i = temp[12][3].length();
                            int j = i / x;
                            String s = temp[12][3].substring(0, j);
                            String s1 = temp[12][3].substring(j, (2 * j));
                            String s2 = temp[12][3].substring((2 * j), i);
                            class103.setText(s);
                            class113.setText(s1);
                            class123.setText(s2);
                        }
                        else {
                            i = temp[12][3].length();
                            int j = i / x;
                            String s = temp[12][3].substring(0, j);
                            String s1 = temp[12][3].substring(j, i);

                            class103.setText(s);
                            class113.setText(s1);

                        }
                    }
                    else {
                        class103.setText(temp[12][3]);
                    }
                }
                //3-10to12

                if(temp[12][4].equals(null))
                {}
                else {
                    int x = 1;
                    int i;
                    if (temp[12][4].equals(temp[13][4])) {
                        x++;
                        if (temp[13][4].equals(temp[14][4])) {
                            x++;
                            i = temp[12][4].length();
                            int j = i / x;
                            String s = temp[12][4].substring(0, j);
                            String s1 = temp[12][4].substring(j, (2 * j));
                            String s2 = temp[12][4].substring((2 * j), i);
                            class104.setText(s);
                            class114.setText(s1);
                            class124.setText(s2);
                        }
                        else {
                            i = temp[12][4].length();
                            int j = i / x;
                            String s = temp[12][4].substring(0, j);
                            String s1 = temp[12][4].substring(j, i);

                            class104.setText(s);
                            class114.setText(s1);

                        }
                    }
                    else {
                        class104.setText(temp[12][4]);
                    }
                }
                //4-10to12

                if(temp[12][5].equals(null))
                {}
                else {
                    int x = 1;
                    int i;
                    if (temp[12][5].equals(temp[13][5])) {
                        x++;
                        if (temp[13][5].equals(temp[14][5])) {
                            x++;
                            i = temp[12][5].length();
                            int j = i / x;
                            String s = temp[12][5].substring(0, j);
                            String s1 = temp[12][5].substring(j, (2 * j));
                            String s2 = temp[12][5].substring((2 * j), i);
                            class105.setText(s);
                            class115.setText(s1);
                            class125.setText(s2);
                        }
                        else {
                            i = temp[12][5].length();
                            int j = i / x;
                            String s = temp[12][5].substring(0, j);
                            String s1 = temp[12][5].substring(j, i);

                            class105.setText(s);
                            class115.setText(s1);

                        }
                    }
                    else {
                        class105.setText(temp[12][5]);
                    }
                }
                //5-10to12





                //////////以上晚间课



                class11.setTextSize(13);
                class12.setTextSize(13);
                class13.setTextSize(13);
                class14.setTextSize(13);
                class15.setTextSize(13);
                class16.setTextSize(13);
                class17.setTextSize(13);

                class21.setTextSize(13);
                class22.setTextSize(13);
                class23.setTextSize(13);
                class24.setTextSize(13);
                class25.setTextSize(13);
                class26.setTextSize(13);
                class27.setTextSize(13);

                class31.setTextSize(13);
                class32.setTextSize(13);
                class33.setTextSize(13);
                class34.setTextSize(13);
                class35.setTextSize(13);
                class36.setTextSize(13);
                class37.setTextSize(13);

                class41.setTextSize(13);
                class42.setTextSize(13);
                class43.setTextSize(13);
                class44.setTextSize(13);
                class45.setTextSize(13);
                class46.setTextSize(13);
                class47.setTextSize(13);

                class51.setTextSize(13);
                class52.setTextSize(13);
                class53.setTextSize(13);
                class54.setTextSize(13);
                class55.setTextSize(13);
                class56.setTextSize(13);
                class57.setTextSize(13);

                class61.setTextSize(13);
                class62.setTextSize(13);
                class63.setTextSize(13);
                class64.setTextSize(13);
                class65.setTextSize(13);
                class66.setTextSize(13);
                class67.setTextSize(13);

                class71.setTextSize(13);
                class72.setTextSize(13);
                class73.setTextSize(13);
                class74.setTextSize(13);
                class75.setTextSize(13);
                class76.setTextSize(13);
                class77.setTextSize(13);

                class81.setTextSize(13);
                class82.setTextSize(13);
                class83.setTextSize(13);
                class84.setTextSize(13);
                class85.setTextSize(13);
                class86.setTextSize(13);
                class87.setTextSize(13);

                class91.setTextSize(13);
                class92.setTextSize(13);
                class93.setTextSize(13);
                class94.setTextSize(13);
                class95.setTextSize(13);
                class96.setTextSize(13);
                class97.setTextSize(13);

                class101.setTextSize(13);
                class102.setTextSize(13);
                class103.setTextSize(13);
                class104.setTextSize(13);
                class105.setTextSize(13);
                class106.setTextSize(13);
                class107.setTextSize(13);

                class111.setTextSize(13);
                class112.setTextSize(13);
                class113.setTextSize(13);
                class114.setTextSize(13);
                class115.setTextSize(13);
                class116.setTextSize(13);
                class117.setTextSize(13);

                class121.setTextSize(13);
                class122.setTextSize(13);
                class123.setTextSize(13);
                class124.setTextSize(13);
                class125.setTextSize(13);
                class126.setTextSize(13);
                class127.setTextSize(13);




            }
            super.handleMessage(msg);
        }
    };

    Intent i=new Intent();
    public static String number=new String();
    public static String password=new String();

    Calendar c = Calendar.getInstance();
    int year =  c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    public kebiao() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kebiao, container, false);

        bt=(Button)view.findViewById(R.id.getclass);

        tv0 = (TextView)view.findViewById(R.id.xq0);
        tv1 = (TextView)view.findViewById(R.id.xq1);
        tv2 = (TextView)view.findViewById(R.id.xq2);
        tv3 = (TextView)view.findViewById(R.id.xq3);
        tv4 = (TextView)view.findViewById(R.id.xq4);
        tv5 = (TextView)view.findViewById(R.id.xq5);
        tv6 = (TextView)view.findViewById(R.id.xq6);
        tv7 = (TextView)view.findViewById(R.id.xq7);

        class11=(TextView)view.findViewById(R.id.class11);
        class12=(TextView)view.findViewById(R.id.class12);
        class13=(TextView)view.findViewById(R.id.class13);
        class14=(TextView)view.findViewById(R.id.class14);
        class15=(TextView)view.findViewById(R.id.class15);
        class16=(TextView)view.findViewById(R.id.class16);
        class17=(TextView)view.findViewById(R.id.class17);

        class21=(TextView)view.findViewById(R.id.class21);
        class22=(TextView)view.findViewById(R.id.class22);
        class23=(TextView)view.findViewById(R.id.class23);
        class24=(TextView)view.findViewById(R.id.class24);
        class25=(TextView)view.findViewById(R.id.class25);
        class26=(TextView)view.findViewById(R.id.class26);
        class27=(TextView)view.findViewById(R.id.class27);

        class31=(TextView)view.findViewById(R.id.class31);
        class32=(TextView)view.findViewById(R.id.class32);
        class33=(TextView)view.findViewById(R.id.class33);
        class34=(TextView)view.findViewById(R.id.class34);
        class35=(TextView)view.findViewById(R.id.class35);
        class36=(TextView)view.findViewById(R.id.class36);
        class37=(TextView)view.findViewById(R.id.class37);

        class41=(TextView)view.findViewById(R.id.class41);
        class42=(TextView)view.findViewById(R.id.class42);
        class43=(TextView)view.findViewById(R.id.class43);
        class44=(TextView)view.findViewById(R.id.class44);
        class45=(TextView)view.findViewById(R.id.class45);
        class46=(TextView)view.findViewById(R.id.class46);
        class47=(TextView)view.findViewById(R.id.class47);

        class51=(TextView)view.findViewById(R.id.class51);
        class52=(TextView)view.findViewById(R.id.class52);
        class53=(TextView)view.findViewById(R.id.class53);
        class54=(TextView)view.findViewById(R.id.class54);
        class55=(TextView)view.findViewById(R.id.class55);
        class56=(TextView)view.findViewById(R.id.class56);
        class57=(TextView)view.findViewById(R.id.class57);

        class61=(TextView)view.findViewById(R.id.class61);
        class62=(TextView)view.findViewById(R.id.class62);
        class63=(TextView)view.findViewById(R.id.class63);
        class64=(TextView)view.findViewById(R.id.class64);
        class65=(TextView)view.findViewById(R.id.class65);
        class66=(TextView)view.findViewById(R.id.class66);
        class67=(TextView)view.findViewById(R.id.class67);

        class71=(TextView)view.findViewById(R.id.class71);
        class72=(TextView)view.findViewById(R.id.class72);
        class73=(TextView)view.findViewById(R.id.class73);
        class74=(TextView)view.findViewById(R.id.class74);
        class75=(TextView)view.findViewById(R.id.class75);
        class76=(TextView)view.findViewById(R.id.class76);
        class77=(TextView)view.findViewById(R.id.class77);


        class81=(TextView)view.findViewById(R.id.class81);
        class82=(TextView)view.findViewById(R.id.class82);
        class83=(TextView)view.findViewById(R.id.class83);
        class84=(TextView)view.findViewById(R.id.class84);
        class85=(TextView)view.findViewById(R.id.class85);
        class86=(TextView)view.findViewById(R.id.class86);
        class87=(TextView)view.findViewById(R.id.class87);

        class91=(TextView)view.findViewById(R.id.class91);
        class92=(TextView)view.findViewById(R.id.class92);
        class93=(TextView)view.findViewById(R.id.class93);
        class94=(TextView)view.findViewById(R.id.class94);
        class95=(TextView)view.findViewById(R.id.class95);
        class96=(TextView)view.findViewById(R.id.class96);
        class97=(TextView)view.findViewById(R.id.class97);

        class101=(TextView)view.findViewById(R.id.class101);
        class102=(TextView)view.findViewById(R.id.class102);
        class103=(TextView)view.findViewById(R.id.class103);
        class104=(TextView)view.findViewById(R.id.class104);
        class105=(TextView)view.findViewById(R.id.class105);
        class106=(TextView)view.findViewById(R.id.class106);
        class107=(TextView)view.findViewById(R.id.class107);

        class111=(TextView)view.findViewById(R.id.class111);
        class112=(TextView)view.findViewById(R.id.class112);
        class113=(TextView)view.findViewById(R.id.class113);
        class114=(TextView)view.findViewById(R.id.class114);
        class115=(TextView)view.findViewById(R.id.class115);
        class116=(TextView)view.findViewById(R.id.class116);
        class117=(TextView)view.findViewById(R.id.class117);

        class121=(TextView)view.findViewById(R.id.class121);
        class122=(TextView)view.findViewById(R.id.class122);
        class123=(TextView)view.findViewById(R.id.class123);
        class124=(TextView)view.findViewById(R.id.class124);
        class125=(TextView)view.findViewById(R.id.class125);
        class126=(TextView)view.findViewById(R.id.class126);
        class127=(TextView)view.findViewById(R.id.class127);

        return view;
    }



    int  data()
    {
        int str[]={7,1,2,3,4,5,6};//字符串数组
        Calendar rightNow=Calendar.getInstance();
        int day=rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        return str[day-1];
    }
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        number=Login.getNumber();
        password=Login.getPassword();

        bt.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(){
                        @Override
                        public void run(){
                            try{
                                getClassTable(number,password);
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                }
                return false;
            }

        });


        tv0.setText((month+1)+"\n月");
        tv1.setText("周一\n"+(day-data()+1)+"号");
        tv2.setText("周二\n"+(day-data()+2)+"号");
        tv3.setText("周三\n"+(day-data()+3)+"号");
        tv4.setText("周四\n"+(day-data()+4)+"号");
        tv5.setText("周五\n"+(day-data()+5)+"号");
        tv6.setText("周六\n"+(day-data()+6)+"号");
        tv7.setText("周日\n"+(day-data()+7)+"号");
        if(data()==1)
        {
            tv1.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if(data()==2){
            tv2.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if (data()==3){
            tv3.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if (data()==4){
            tv4.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if (data()==5){
            tv5.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if (data()==6){
            tv6.setBackgroundColor(Color.parseColor("#2453b8"));
        }
        else if (data()==7){
            tv7.setBackgroundColor(Color.parseColor("#2453b8"));
        }

    }
    public void  getClassTable(String zjh,String mm) throws IOException {
        useKebiao=new String[16][8];
        Message msg=new Message();
        Map<String,String> loginPageCookies= Jsoup.connect("http://zhjw.scu.edu.cn/loginAction.do")
                .data("zjh",zjh,"mm",mm)
                .method(Connection.Method.POST).execute().cookies();

        Document document=Jsoup.connect("http://zhjw.scu.edu.cn/syglSyxkAction.do?&oper=xsxkKcbAll")
                .cookies(loginPageCookies).post();

        Element element = document.getElementById("user");
        Elements trElements = element.select("tr");

        for (int i = 0; i < trElements.size(); i++) {
            Elements tdElements = trElements.get(i).select("td");
            for (int j = 0; j < tdElements.size(); j++) {
                String text = tdElements.get(j).text();
                if (tdElements.size() == 1) {
                    continue;
                }
                else if (tdElements.size()==9) {
                    if (j != 0)
                        useKebiao[i][j-1] = text;
                }
                else
                    useKebiao[i][j] = text;
            }
        }
        msg.what=HASCRAWLCT;
        msg.obj=useKebiao;
        handler.sendMessage(msg);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public void onDetach() {super.onDetach();}

}
