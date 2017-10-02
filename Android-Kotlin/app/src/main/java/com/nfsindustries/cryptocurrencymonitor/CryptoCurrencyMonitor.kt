package com.nfsindustries.cryptocurrencymonitor

import android.app.Application
import android.content.Context

/**
 * Class used for Context and support functions
 * Created by MaxMouse on 21/9/2017.
 */
class CryptoCurrencyMonitor : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {

        var appContext: Context? = null
            private set
    }
}
