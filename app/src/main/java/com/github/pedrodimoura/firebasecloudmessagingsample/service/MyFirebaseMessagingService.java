package com.github.pedrodimoura.firebasecloudmessagingsample.service;

import android.app.Notification;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("MyFirebaseMessaging", "onMessageReceived");
        Log.d("MyFirebaseMessaging", "Message ID: " + remoteMessage.getMessageId());
        Log.d("MyFirebaseMessaging", "Message From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            RemoteMessage.Notification n = remoteMessage.getNotification();

            NotificationCompat.Builder mBuilder
                    = new NotificationCompat.Builder(this, "teste")
                    .setSmallIcon(android.R.drawable.ic_menu_agenda)
                    .setContentTitle("Teste")
                    .setContentText(n.getBody())
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
            notificationManagerCompat.notify(1992, mBuilder.build());

            Log.d("MyFirebaseMessaging", "Message Body: " + n.getBody());
        } else {
            Log.d("MyFirebaseMessaging", "Message Data: Empty");
        }
    }
}
