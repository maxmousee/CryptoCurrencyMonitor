package com.nfsindustries.cryptocurrencymonitor.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel;

import java.lang.reflect.Type;

/**
 * Created by maxmo on 26/5/2017.
 */

public class CoinmarketcapDeserializer implements JsonDeserializer<CryptoCurrencyModel> {

    @Override
    public CryptoCurrencyModel deserialize(final JsonElement json, final Type typeOfT,
                                    final JsonDeserializationContext context)
            throws JsonParseException {

        final JsonArray rootJsonArray =  json.getAsJsonArray();
        final JsonElement usdJson = rootJsonArray.get(0);

        final Gson gson = new Gson();
        final CryptoCurrencyModel cryptoCurrencyModel = gson.fromJson(usdJson, CryptoCurrencyModel.class);

        return cryptoCurrencyModel;
    }
}