package com.wzes.vmovie.base;

import android.app.Application;


public class BaseApplication extends Application {
    public void onCreate() {
        super.onCreate();
        DemoCache.setContext(this);
    }

}
