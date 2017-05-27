package com.nfsindustries.cryptocurrencymonitor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nfsindustries.cryptocurrencymonitor.utils.TextFormatter;

public class CryptoCurrencyModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("price_usd")
    @Expose
    private float priceUsd;
    @SerializedName("price_btc")
    @Expose
    private float priceBtc;
    @SerializedName("24h_volume_usd")
    @Expose
    private float _24hVolumeUsd;
    @SerializedName("market_cap_usd")
    @Expose
    private float marketCapUsd;
    @SerializedName("available_supply")
    @Expose
    private float availableSupply;
    @SerializedName("total_supply")
    @Expose
    private float totalSupply;
    @SerializedName("percent_change_1h")
    @Expose
    private float percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    private float percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    private float percentChange7d;
    @SerializedName("last_updated")
    @Expose
    private long lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(float priceUsd) {
        this.priceUsd = priceUsd;
    }

    public float getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(float priceBtc) {
        this.priceBtc = priceBtc;
    }

    public float get24hVolumeUsd() {
        return _24hVolumeUsd;
    }

    public void set24hVolumeUsd(float _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
    }

    public float getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(float marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public float getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(float availableSupply) {
        this.availableSupply = availableSupply;
    }

    public float getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(float totalSupply) {
        this.totalSupply = totalSupply;
    }

    public float getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(float percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public float getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(float percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public float getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(float percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        final StringBuilder displayStrBuilder = new StringBuilder("1 ");
        displayStrBuilder.append(name);
        displayStrBuilder.append(" to ");
        displayStrBuilder.append("USD");
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("Last: ");
        displayStrBuilder.append(TextFormatter.formatCurrency(priceUsd));
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("Change 1h: ");
        displayStrBuilder.append(percentChange1h);
        displayStrBuilder.append("%\n\n");
        displayStrBuilder.append("Change 24h: ");
        displayStrBuilder.append(percentChange24h);
        displayStrBuilder.append("%\n\n");
        displayStrBuilder.append("Change 7d: ");
        displayStrBuilder.append(percentChange7d);
        displayStrBuilder.append("%\n\n");
        return displayStrBuilder.toString();
    }

}