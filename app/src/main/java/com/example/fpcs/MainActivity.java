package com.example.fpcs;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import static com.example.fpcs.R.*;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder nbuilder = new NotificationCompat.Builder(this);
    int count=0,countT=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Button DN = (Button)findViewById(id.dn);
        Button CN = (Button)findViewById(id.cn);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void defaultNotification(View view) {
                nbuilder.setSmallIcon(drawable.notification_icon);
                nbuilder.setContentTitle("This is Default Notification");
                nbuilder.setContentText("This is a default notification example");
                nbuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(count++, nbuilder.build());
    }

    public void customNotification(View view) {
        nbuilder.setSmallIcon(drawable.notification_icon_custom);
        nbuilder.setContentTitle("This is custom Notification");
        nbuilder.setContentText("This is a custom notification example");

        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        uri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + raw.oh_my_god);
        nbuilder.setSound(uri);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(countT++, nbuilder.build());
    }
}