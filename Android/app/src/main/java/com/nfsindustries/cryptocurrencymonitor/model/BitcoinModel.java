package com.nfsindustries.cryptocurrencymonitor.model;

/**
 * Created by maxmouse on 18/5/2017.
 */

public class BitcoinModel {

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */

    /**
     * A currency item representing a piece of content.
     */
    public static class BitcoinItem {
        public final String id;
        public final String last15m;
        public final String symbol;
        public final float last;
        public final float sell;
        public final float buy;

        public BitcoinItem(String id, String last15m, String symbol, float last, float sell, float buy) {
            this.id = id;
            this.last15m = last15m;
            this.symbol = symbol;
            this.last = last;
            this.sell = sell;
            this.buy = buy;
        }

        @Override
        public String toString() {
            return id + " " + symbol + " " + last + " " + last15m + " " + buy + " " + sell;
        }
    }
}