package com.example.nekto404.virtualkeyboard;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;


import timber.log.Timber;

/**
 * Created by nekto404 on 05.09.2016.
 */
public class VKApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initTimber();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }
}
