package com.example.notificationchannel;

import android.app.Application;
import android.app.NotificationManager;
import android.os.Build;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

public class NotificationChannel extends Application {

    public static final String CHANNEL_1_ID = "Channel-1-ID";
    public static final String CHANNEL_2_ID = "Channel-2-ID";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificatoinChannel();
    }
    public void  createNotificatoinChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Channel1
            android.app.NotificationChannel channel1 = new android.app.NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            //Channel2
            android.app.NotificationChannel channel2 = new android.app.NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");
            long[] longs = {0 , 200 , 2000} ;
            channel2.setVibrationPattern(longs);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
