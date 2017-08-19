package com.craftnet.mvpdaggerexample.Activity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.craftnet.mvpdaggerexample.Event.NetworkStateChanged;
import com.craftnet.mvpdaggerexample.Service.NetworkStateReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * Created by shaan on 7/25/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {



    NetworkStateReceiver mReciever;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        mReciever = new NetworkStateReceiver();
        ButterKnife.bind(this);
        dependency();
        initialize();
    }

    public abstract void initialize();

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(mReciever, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        this.unregisterReceiver(mReciever);
    }

    public abstract int layout();


    public abstract void dependency();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkStateChangedEvent(NetworkStateChanged event) {
        if (!event.isInternetConnected()) {
            ondisconnected();
        } else {
            onconnected();
        }
    }

    public abstract void ondisconnected();
    public abstract void onconnected();


}
