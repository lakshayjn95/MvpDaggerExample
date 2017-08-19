package com.craftnet.mvpdaggerexample.Di.Module;

/**
 * Created by shaan on 8/16/2017.
 */

import android.content.Context;


import com.craftnet.mvpdaggerexample.Di.Client;
import com.craftnet.mvpdaggerexample.Di.MyToast;
import com.craftnet.mvpdaggerexample.Di.SessionManager;
import com.craftnet.mvpdaggerexample.Network.OkRetro;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context context(){
        return this.context;
    }

    @Singleton
    @Provides
    public SessionManager sessionManager(Context context){
        return SessionManager.with(context);
    };

    @Singleton
    @Provides
    public OkRetro client(Context context, SessionManager sessionManager){
        return Client.with(context,sessionManager).build();
    };

    @Singleton
    @Provides
    public MyToast toast(Context context){
        return MyToast.with(context);
    }

}
