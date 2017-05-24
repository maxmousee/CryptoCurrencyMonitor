package com.nfsindustries.cryptocurrencymonitor.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

/**
 * Created by maxmo on 24/5/2017.
 */

public class BitcoinIndexDeserializer implements JsonDeserializer<BitcoinModel> {

    @Override
    public BitcoinModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final BitcoinModel bitcoin = new BitcoinModel(Constants.BTC_KEY, Constants.USD_KEY, 1000, 1000, 1000, 1000);
        final JsonObject bitcoinIndexJsonObject =  json.getAsJsonObject();

        /*
        bitcoin.name = bitcoinIndexJsonObject.get(Constants.USD_KEY).getAsString();
        githubRepo.url = bitcoinIndexJsonObject.get("url").getAsString();

        JsonElement ownerJsonElement = bitcoinIndexJsonObject.get("owner");
        JsonObject ownerJsonObject = ownerJsonElement.getAsJsonObject();
        bitcoin.owner = ownerJsonObject.get("login").getAsString();
        */

        return bitcoin;
    }
}