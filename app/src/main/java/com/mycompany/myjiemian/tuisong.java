package com.mycompany.myjiemian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static com.mycompany.myjiemian.R.layout.activity_bisai;

public class tuisong extends Fragment {
    private Intent intent;
    private ImageButton bisai;
    private ImageButton jiangzuo;
    private ImageButton xueyuan;

    public tuisong() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_tuisong ,container, false);
        bisai = (ImageButton) view.findViewById(R.id.bisai);
        jiangzuo = (ImageButton) view.findViewById(R.id.jiangzuo);
        xueyuan = (ImageButton) view.findViewById(R.id.xueyuan);
        return view;
    }



    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        bisai.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    intent=new Intent(getActivity(),bisai.class);
                    startActivity(intent);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                }
                return false;
            }
        });

        jiangzuo.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    intent=new Intent(getActivity(),Speech.class);
                    startActivity(intent);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

                }
                return false;
            }
        });

        xueyuan.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    intent=new Intent(getActivity(),CollegeInfo.class);
                    startActivity(intent);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

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



