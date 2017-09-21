package com.nfsindustries.cryptocurrencymonitor

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log

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
        }

        // Add Cache Control only for GET methods
        if (request.method() == "GET") {
            if (isConnected) {
                request = request.newBuilder()
                        .header("Cache-Control", "only-if-cached")
                        .build()
            } else {
                // 4 weeks stale
                request = request.newBuilder()
                        .header("Cache-Control", "public, max-stale=2419200")
                        .build()
            }
        }

        val originalResponse = chain.proceed(request)
        return originalResponse.newBuilder()
                .header("Cache-Control", "max-age=900")
                .build()
    }
}
