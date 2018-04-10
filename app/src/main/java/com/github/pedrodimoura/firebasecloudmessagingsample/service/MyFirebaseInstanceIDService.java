package com.github.pedrodimoura.firebasecloudmessagingsample.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        Log.d("MyFirebaseInstance", FirebaseInstanceId.getInstance().getToken());

    }
}
