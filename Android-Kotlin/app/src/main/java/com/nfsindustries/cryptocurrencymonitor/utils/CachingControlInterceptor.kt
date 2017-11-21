package com.nfsindustries.cryptocurrencymonitor.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.nfsindustries.cryptocurrencymonitor.CryptoCurrencyMonitor

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Controls network cache for REST calls
 */
class CachingControlInterceptor : Interceptor {
    internal val context = CryptoCurrencyMonitor.appContext

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var isConnected = false

        try {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        } catch (exception: NullPointerException) {
            Log.e("CHECKING_CONNECTION", exception.toString())
            exception.printStackTrace()
        }

        // Add Cache Control only for GET methods
        // Should always be true because we only have one request right now
        if (request.method() == "GET") {
            when (isConnected) {
                true -> request = request.newBuilder().build()
                false -> request = request.newBuilder()
                        .header(Constants.CACHE_CTRL, Constants.CACHE_MAX_STALE)
                        .build()
            }
        }

        val originalResponse = chain.proceed(request)
        return originalResponse.newBuilder()
                .header(Constants.CACHE_CTRL, Constants.CACHE_MAX_AGE)
                .build()
    }
}
