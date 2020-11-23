package com.example.notificationchannel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.notificationchannel.NotificationChannel.CHANNEL_1_ID;
import static com.example.notificationchannel.NotificationChannel.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat managerCompat ;
    public EditText title , des ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerCompat = NotificationManagerCompat.from(this);
        title = (EditText) findViewById(R.id.title);
        des = (EditText) findViewById(R.id.des);

    }

    public  void  setChannel1 (View v){

        String Title = title.getText().toString();
        String message = des.getText().toString();

        Notification notification = new NotificationCompat.Builder(this , CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_sms_24)
                .setContentTitle(Title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        managerCompat.notify(1 , notification);
    }

    public  void  setChannel2 (View v){

        String Title = title.getText().toString();
        String message = des.getText().toString();

        Notification notification = new NotificationCompat.Builder(this , CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_sms_24)
                .setContentTitle(Title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        managerCompat.notify(2 , notification);
    }
}