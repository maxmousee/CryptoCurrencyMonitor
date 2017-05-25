package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.deserializer.BitcoinIndexDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maxmo on 24/5/2017.
 */

public class BitcoinService implements Callback<BitcoinModel> {

    public void start() {
        final Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(BitcoinModel.class, new BitcoinIndexDeserializer())
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BITCOIN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final BitcoinAPI bitcoinAPI = retrofit.create(BitcoinAPI.class);
        final Call<BitcoinModel> call = bitcoinAPI.getCurrentIndex();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<BitcoinModel> call, Response<BitcoinModel> response) {
        if(response.isSuccessful()) {
            final BitcoinModel currencyIndex = response.body();
            //TODO RETURN OBJECT AND DISPLAY
            Log.d("RESPONSE", response.toString());
        } else {
            Log.e("BITCOIN_INDEX", response.toString());
        }
    }

    @Override
    public void onFailure(Call<BitcoinModel> call, Throwable t) {
        t.printStackTrace();
    }
}