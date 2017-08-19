package com.craftnet.mvpdaggerexample.Event;

/**
 * Created by shaan on 7/7/2017.
 */

public class NetworkStateChanged {

    private boolean mIsInternetConnected;

    public NetworkStateChanged(boolean isInternetConnected) {
        this.mIsInternetConnected = isInternetConnected;
    }

    public boolean isInternetConnected() {
        return this.mIsInternetConnected;
    }
}
