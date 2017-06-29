package com.example.zhou.player.Base;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhou on 2017/5/28.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
