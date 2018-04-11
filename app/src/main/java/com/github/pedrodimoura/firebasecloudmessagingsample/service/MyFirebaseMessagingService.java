package com.github.pedrodimoura.firebasecloudmessagingsample.service;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.github.pedrodimoura.firebasecloudmessagingsample.model.Settings;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String BROADCAST_EVENT = "firebase-custom-intent-broadcast";
    public static final String BROADCAST_EXTRA = "broadcast-extra";
    public static final String SYNC_TIME_INTERVAL_KEY = "sync_time_interval";
    public static final String GPS_TIME_INTERVAL = "gps_time_interval";
    public static final String GPS_DISTANCE_INTERVAL = "gps_distance_interval";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getNotification() != null) {
            LocalBroadcastManager localBroadcastManager
                    = LocalBroadcastManager.getInstance(getApplicationContext());

            Intent intent = new Intent(BROADCAST_EVENT);

            RemoteMessage.Notification n = remoteMessage.getNotification();

            Settings s = new Settings();

            s.setSyncTimeInterval(remoteMessage.getData().get(SYNC_TIME_INTERVAL_KEY));
            s.setGpsTimeInterval(remoteMessage.getData().get(GPS_TIME_INTERVAL));
            s.setGpsDistanceInterval(remoteMessage.getData().get(GPS_DISTANCE_INTERVAL));

            intent.putExtra(BROADCAST_EXTRA, s);

            localBroadcastManager.sendBroadcast(intent);
        }
    }
}
