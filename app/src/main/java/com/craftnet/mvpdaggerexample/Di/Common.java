package com.craftnet.mvpdaggerexample.Di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by shaan on 7/8/2017.
 */

public class Common {


    Context mContext;

    public static Common build(){
        return  new Common();
    }


    public static Common build(Context C){
        Common common=new Common();
        common.mContext=C;
        return  common;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

}
