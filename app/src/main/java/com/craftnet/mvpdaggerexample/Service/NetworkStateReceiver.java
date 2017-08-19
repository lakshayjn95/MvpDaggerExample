package com.craftnet.mvpdaggerexample.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.craftnet.mvpdaggerexample.Event.NetworkStateChanged;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by shaan on 7/7/2017.
 */

public class NetworkStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            NetworkInfo ni = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED) {
                EventBus.getDefault().post(new NetworkStateChanged(true));
            } else {
                EventBus.getDefault().post(new NetworkStateChanged(false));
            }
        }

    }
}
