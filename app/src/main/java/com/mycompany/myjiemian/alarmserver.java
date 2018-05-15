package com.mycompany.myjiemian;

/**
 * Created by 647 on 2017/12/7.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

public class alarmserver extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent) {
        intent = new Intent(context,future.class);
        PendingIntent pi= PendingIntent.getActivity(context,0,intent,0);
        NotificationManager manager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification=new NotificationCompat.Builder(context)
                .setContentTitle("SCU-CT")
                .setContentText("你有新的提醒")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.tubiao)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.tubiao)).build();
        manager.notify(1,notification);

    }
        }
