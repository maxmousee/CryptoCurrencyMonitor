package com.nfsindustries.cryptocurrencymonitor.service.coinmarket

import com.google.gson.GsonBuilder
import com.nfsindustries.cryptocurrencymonitor.utils.Constants
import com.nfsindustries.cryptocurrencymonitor.CryptoCurrencyMonitor
import com.nfsindustries.cryptocurrencymonitor.deserializer.CoinmarketcapDeserializer
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel
import com.nfsindustries.cryptocurrencymonitor.utils.CachingControlInterceptor

import java.io.File

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface to get Crypto Currency data from CoinMarket API.
 * Created by MaxMouse on 9/21/17.
 */
interface CoinmarketCapAPI {

    @GET("{cryptocurrency}?convert=USD")
    fun getCurrentIndex(@Path("cryptocurrency") cryptocurrency: String): Call<CryptoCurrencyModel>

    companion object {

        val CACHE_SIZE = (20 * 1024 * 1024).toLong() // 20 MiB
        val COIN_MARKETCAP_BASE_URL = "https://api.coinmarketcap.com/v1/"
        val TICKER = "ticker"
        val context = CryptoCurrencyMonitor.appContext
        val cache = Cache(File(context?.getCacheDir(), "http"), CACHE_SIZE)
        val networkInterceptor = CachingControlInterceptor()

        //TODO FIX this instant run bullshit

        val client = OkHttpClient.Builder().cache(cache).addNetworkInterceptor(networkInterceptor).build()

        val gson = GsonBuilder()
                .setLenient()
                .registerTypeAdapter(CryptoCurrencyModel::class.java, CoinmarketcapDeserializer())
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(COIN_MARKETCAP_BASE_URL + TICKER + "/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}