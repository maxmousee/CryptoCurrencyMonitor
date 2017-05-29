package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.deserializer.CoinmarketcapDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel;
import com.nfsindustries.cryptocurrencymonitor.utils.CachingControlInterceptor;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by maxmo on 29/5/2017.
 */

public class CoinmarketCapCachedService implements CoinmarketCapAPI {

    Retrofit theRetrofit;

    public CoinmarketCapCachedService(final Context context) {
        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(context.getCacheDir(), "http"), SIZE_OF_CACHE);
        final CachingControlInterceptor networkInterceptor = new CachingControlInterceptor();
        networkInterceptor.setContext(context);
        final OkHttpClient client = new OkHttpClient.Builder().cache(cache).addInterceptor(networkInterceptor).build();
        client.networkInterceptors().add(new CachingControlInterceptor());

        final Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(CryptoCurrencyModel.class, new CoinmarketcapDeserializer())
                .create();

        theRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.COIN_MARKETCAP_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Override
    @GET("{cryptocurrency}?convert=USD")
    public Call<CryptoCurrencyModel> getCurrentIndex(@Path("cryptocurrency") String cryptocurrency) {
        final CoinmarketCapAPI coinmarketCapService = theRetrofit.create(CoinmarketCapAPI.class);
        return coinmarketCapService.getCurrentIndex(cryptocurrency);
    }
}
