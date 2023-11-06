package com.example.notificationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Anupam Channel";
    private static final Integer NOTIFICATION_ID = 123;
    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Converting drawable to bitmap image...
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.database,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE, intent, PendingIntent.FLAG_IMMUTABLE);

        // Big Picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.database, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Anupam")
                .setSummaryText("Image Message");

        // Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Anurag");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.database)
                    .setContentIntent(pi)
                    .setContentText("New Message")
                    .setSubText("New Message from Anupam")
                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(
                    new NotificationChannel(
                            CHANNEL_ID,
                            "New Channel",
                            NotificationManager.IMPORTANCE_HIGH
                    )
            );
        } else {
            notification = new Notification.Builder(this).setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.database)
                    .setContentText("New Message")
                    .setSubText("New Message from Anupam")
                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setContentIntent(pi)
                    .build();
        }
        nm.notify(NOTIFICATION_ID, notification);
    }
}