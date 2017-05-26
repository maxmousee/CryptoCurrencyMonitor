package com.nfsindustries.cryptocurrencymonitor.model;

/**
 * Created by maxmouse on 18/5/2017.
 */

public final class CurrencyListItem {

    private final String name;
    private int logo;

    public String getName() {
        return name;
    }

    public int getLogo() {
        return logo;
    }

    public CurrencyListItem(final String name, final int logo) {
        this.name = name;
        this.logo = logo;
    }
}