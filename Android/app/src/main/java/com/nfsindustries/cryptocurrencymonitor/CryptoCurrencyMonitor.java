package com.nfsindustries.cryptocurrencymonitor;

import android.app.Application;
import android.content.Context;

/**
 * Created by maxmo on 29/5/2017.
 */

public class CryptoCurrencyMonitor extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        CryptoCurrencyMonitor.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return CryptoCurrencyMonitor.context;
    }
}