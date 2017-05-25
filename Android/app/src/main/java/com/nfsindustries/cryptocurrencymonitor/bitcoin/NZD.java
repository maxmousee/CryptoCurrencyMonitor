
package com.nfsindustries.cryptocurrencymonitor.bitcoin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NZD {

    @SerializedName("15m")
    @Expose
    private float _15m;
    @SerializedName("last")
    @Expose
    private float last;
    @SerializedName("buy")
    @Expose
    private float buy;
    @SerializedName("sell")
    @Expose
    private float sell;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public float get15m() {
        return _15m;
    }

    public void set15m(float _15m) {
        this._15m = _15m;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
