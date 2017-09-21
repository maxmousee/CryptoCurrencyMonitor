package com.nfsindustries.cryptocurrencymonitor.deserializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel

import java.lang.reflect.Type

/**
 * Deserializer for CoinMarketCap API, used to convert data from JSON
 * It uses Google's GSON parsing library
 * For now, it only converts USD [United States Dollar]
 * TODO add support for other countries' currencies
 */

class CoinmarketcapDeserializer : JsonDeserializer<CryptoCurrencyModel> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type,
                             context: JsonDeserializationContext): CryptoCurrencyModel {

        val rootJsonArray = json.asJsonArray
        val usdJson = rootJsonArray.get(0)

        val gson = Gson()

        return gson.fromJson(usdJson, CryptoCurrencyModel::class.java)
    }
}