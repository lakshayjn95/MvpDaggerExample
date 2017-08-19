package com.craftnet.mvpdaggerexample.Di;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by shaan on 7/7/2017.
 */

public class SessionManager {


    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    private static int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "c2c";


    public static SessionManager with(Context context) {
        SessionManager sessionManager = new SessionManager();
        sessionManager._context = context;
        sessionManager.pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        sessionManager.editor = sessionManager.pref.edit();
        return sessionManager;
    }

    public void setCity(int city){
        editor.putInt("city_id",city);
        editor.commit();
    }

    public int city(){
        return pref.getInt("city_id",1);
    }


}
