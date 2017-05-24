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
        final BitcoinModel bitcoin = new BitcoinModel();
        final JsonObject repoJsonObject =  json.getAsJsonObject();

        /*
        JsonObject repoJsonObject =  json.getAsJsonObject();
        bitcoin.name = repoJsonObject.get(Constants.USD_KEY).getAsString();
        githubRepo.url = repoJsonObject.get("url").getAsString();

        JsonElement ownerJsonElement = repoJsonObject.get("owner");
        JsonObject ownerJsonObject = ownerJsonElement.getAsJsonObject();
        bitcoin.owner = ownerJsonObject.get("login").getAsString();
        */

        return bitcoin;
    }
}