package com.nfsindustries.cryptocurrencymonitor.model;

/**
 * Created by maxmouse on 18/5/2017.
 */

public final class CurrencyListItem {

    private final String name;
    private final String symbol;

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public CurrencyListItem(final String name, final String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}