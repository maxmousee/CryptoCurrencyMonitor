package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.deserializer.CoinmarketcapDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by maxmo on 23/5/2017.
 */

public interface CoinmarketCapAPI {

    Gson gson = new GsonBuilder()
            .setLenient()
            .registerTypeAdapter(CryptoCurrencyModel.class, new CoinmarketcapDeserializer())
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.COIN_MARKETCAP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @GET("{cryptocurrency}?convert=USD")
    Call<CryptoCurrencyModel> getCurrentIndex(@Path("cryptocurrency") String cryptocurrency);
}
