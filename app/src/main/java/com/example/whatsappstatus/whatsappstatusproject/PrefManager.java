package com.example.whatsappstatus.whatsappstatusproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;

public class PrefManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private String PREF_NAME = "VrajalModi-Welcome";
    private String FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(FIRST_TIME_LAUNCH, true);
    }
}
