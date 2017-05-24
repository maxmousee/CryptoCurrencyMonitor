package com.nfsindustries.cryptocurrencymonitor.model;

/**
 * Created by maxmouse on 18/5/2017.
 */

public class BitcoinModel {

    private final String id;
    private final String destinationCurrency;
    private final float last15m;
    private final float last;
    private final float sell;
    private final float buy;

    public BitcoinModel(String id, String destinationCurrency, float last15m,
                        float last, float sell, float buy) {
        this.id = id;
        this.last15m = last15m;
        this.destinationCurrency = destinationCurrency;
        this.last = last;
        this.sell = sell;
        this.buy = buy;
    }

    public String getId() {
        return id;
    }

    public float getLast15m() {
        return last15m;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public float getLast() {
        return last;
    }

    public float getSell() {
        return sell;
    }

    public float getBuy() {
        return buy;
    }

    @Override
    public String toString() {
        return id + " " + destinationCurrency + " " + last + " " + last15m + " " + buy + " " + sell;
    }
}