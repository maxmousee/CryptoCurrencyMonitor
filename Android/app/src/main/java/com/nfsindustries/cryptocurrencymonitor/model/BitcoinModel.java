package com.nfsindustries.cryptocurrencymonitor.model;

import com.nfsindustries.cryptocurrencymonitor.utils.TextFormatter;

/**
 * Created by maxmouse on 18/5/2017.
 */

public class BitcoinModel {

    private final String id;
    private final String destinationCurrency;
    private final String destSymbol;
    private final float last15m;
    private final float last;
    private final float sell;
    private final float buy;

    //private final boolean isGoingUp;
    //TODO ADD CURRENCY STATUS, if it is going up or down

    public BitcoinModel(String destSymbol, String id, String destinationCurrency, float last15m,
                        float last, float sell, float buy) {
        this.id = id;
        this.last15m = last15m;
        this.destinationCurrency = destinationCurrency;
        this.last = last;
        this.sell = sell;
        this.buy = buy;
        this.destSymbol = destSymbol;
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

    public String getDestinationSymbol() {
        return destSymbol;
    }

    @Override
    public String toString() {
        final StringBuilder displayStrBuilder = new StringBuilder("1 ");
        displayStrBuilder.append(id);
        displayStrBuilder.append(" to ");
        displayStrBuilder.append(destinationCurrency);
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("Last: ");
        displayStrBuilder.append(TextFormatter.formatCurrency(last));
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("Buy: ");
        displayStrBuilder.append(TextFormatter.formatCurrency(buy));
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("Sell: ");
        displayStrBuilder.append(TextFormatter.formatCurrency(sell));
        displayStrBuilder.append("\n\n");
        displayStrBuilder.append("15 mins ago: ");
        displayStrBuilder.append(TextFormatter.formatCurrency(last15m));
        displayStrBuilder.append("\n");
        return displayStrBuilder.toString();
    }
}