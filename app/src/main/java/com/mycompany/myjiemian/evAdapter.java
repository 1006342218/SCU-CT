package com.mycompany.myjiemian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
* Created by 647 on 2017/12/3.
*/

public class evAdapter extends ArrayAdapter<ev>  {
   private int resourceId;
   public evAdapter(Context context, int textViewResourceId, List<ev> objects){
       super(context ,textViewResourceId, objects);
       resourceId=textViewResourceId;
   }
   @Override
   public View getView(int position , View convertView, ViewGroup parent){
       ev ev=getItem(position);
       View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
       TextView evevent =(TextView) view.findViewById(R.id.textView);
       TextView evtime =(TextView) view.findViewById(R.id.timeView);
       evevent.setText(ev.getEvent());
       evtime.setText(ev.getTime());
       return view;
   }
}