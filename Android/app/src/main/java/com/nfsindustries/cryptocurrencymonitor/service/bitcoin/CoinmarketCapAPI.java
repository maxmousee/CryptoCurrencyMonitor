package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.CryptoCurrencyMonitor;
import com.nfsindustries.cryptocurrencymonitor.deserializer.CoinmarketcapDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel;
import com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.CachingControlInterceptor;
import com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.Constants;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by maxmo on 23/5/2017.
 */

public interface CoinmarketCapAPI {

    Context context = CryptoCurrencyMonitor.getAppContext();
    Cache cache = new Cache(new File(context.getCacheDir(), "http"), Constants.CACHE_SIZE);
    CachingControlInterceptor networkInterceptor = new CachingControlInterceptor();

    OkHttpClient client = new OkHttpClient.Builder().cache(cache).addNetworkInterceptor(networkInterceptor).build();

    Gson gson = new GsonBuilder()
            .setLenient()
            .registerTypeAdapter(CryptoCurrencyModel.class, new CoinmarketcapDeserializer())
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.COIN_MARKETCAP_BASE_URL + Constants.TICKER + "/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @GET("{cryptocurrency}?convert=USD")
    Call<CryptoCurrencyModel> getCurrentIndex(@Path("cryptocurrency") String cryptocurrency);
}
