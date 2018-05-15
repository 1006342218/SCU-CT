package com.mycompany.myjiemian;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io

        .IOException;
import java.util.Map;

import static com.mycompany.myjiemian.R.id.class11;

public class Login extends AppCompatActivity{
    private String[][] kebiao;
    private EditText number;
    private EditText password;
    private Button Login;
    private static  final int HASCRAWLCT=1;
    public static String Number=new String();
    public static String Password=new String();







    public static String getNumber(){
        return Number;
    }
    public static String getPassword(){
        return Password;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        number=(EditText)findViewById(R.id.number);
        password=(EditText)findViewById(R.id.password);
        Number=number.getText().toString();
        Password=password.getText().toString();
        password.setTransformationMethod(new PasswordTransformationMethod());


        Login=(Button)findViewById(R.id.login);
        Login.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {


                        Number=number.getText().toString();
                        Password=password.getText().toString();
                    if(Number.length()==13&&Password.length()==6) {
                        Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        password.setText("");
                        number.setText("");
                        Toast.makeText(Login.this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                }
                return false;
            }
        });

    }


}