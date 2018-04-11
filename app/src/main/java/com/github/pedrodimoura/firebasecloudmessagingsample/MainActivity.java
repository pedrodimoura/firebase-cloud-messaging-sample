package com.github.pedrodimoura.firebasecloudmessagingsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.pedrodimoura.firebasecloudmessagingsample.databinding.ActivityMainBinding;
import com.github.pedrodimoura.firebasecloudmessagingsample.model.Settings;
import com.github.pedrodimoura.firebasecloudmessagingsample.service.MyFirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(MyFirebaseMessagingService.BROADCAST_EVENT);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mBroadcastReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mBroadcastReceiver);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Settings s = (Settings) intent.getSerializableExtra(MyFirebaseMessagingService.BROADCAST_EXTRA);

            if (s != null) {
                mActivityMainBinding.textViewSyncInterval.setText(s.getSyncTimeInterval());
                mActivityMainBinding.textViewGpsTime.setText(s.getGpsTimeInterval());
                mActivityMainBinding.textViewGpsDistance.setText(s.getGpsDistanceInterval());
            }
        }
    };
}
