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
    public BitcoinModel deserialize(final JsonElement json, final Type typeOfT,
                                    final JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject bitcoinIndexJsonObject =  json.getAsJsonObject();
        final JsonObject usdJsonObject = bitcoinIndexJsonObject.getAsJsonObject(Constants.USD_KEY);
        final float last15m = usdJsonObject.get(Constants.LAST_15M_KEY).getAsFloat();
        final float last = usdJsonObject.get(Constants.LAST_KEY).getAsFloat();
        final float buy = usdJsonObject.get(Constants.BUY_KEY).getAsFloat();
        final float sell = usdJsonObject.get(Constants.SELL_KEY).getAsFloat();
        final String destinationSymbol = usdJsonObject.get(Constants.SYMBOL_KEY).getAsString();


        final BitcoinModel bitcoin = new BitcoinModel(destinationSymbol, Constants.BTC_KEY, Constants.USD_KEY,
                last15m, last, sell, buy);

        return bitcoin;
    }
}