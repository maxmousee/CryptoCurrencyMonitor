package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.deserializer.BitcoinIndexDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by maxmo on 23/5/2017.
 */

public interface BitcoinAPI {

    Gson blockchainGson = new GsonBuilder()
            .setLenient()
            .registerTypeAdapter(BitcoinModel.class, new BitcoinIndexDeserializer())
            .create();

    Retrofit blockchainRetrofit = new Retrofit.Builder()
            .baseUrl(Constants.BLOCKCHAIN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(blockchainGson))
            .build();

    @GET(Constants.BITCOIN_INDEX)
    Call<BitcoinModel> getCurrentIndex();
}
