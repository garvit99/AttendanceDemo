package com.example.attendancedemo;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;
    // Shared preferences file name
    private static final String PREF_NAME = "My Pref";
    private static final String IS_FIRST_TIME_REGISTER = "IsFirstTimeRegister";
    //private static final String IS_FIRST_TIME_LOGIN = "IsFirstTimeLogin";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeRegister(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_REGISTER, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeRegister() {
        return pref.getBoolean(IS_FIRST_TIME_REGISTER, true);
    }

   /* public void setFirstTimeLogin(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LOGIN, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLogin() {
        return pref.getBoolean(IS_FIRST_TIME_LOGIN, true);
    }*/
}
