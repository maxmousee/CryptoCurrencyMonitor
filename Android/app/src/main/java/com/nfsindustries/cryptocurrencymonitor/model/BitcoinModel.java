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
    public class BitcoinItem {
        private final String id;
        private final String last15m;
        private final String symbol;
        private final float last;
        private final float sell;
        private final float buy;

        public BitcoinItem(String id, String last15m, String symbol, float last, float sell, float buy) {
            this.id = id;
            this.last15m = last15m;
            this.symbol = symbol;
            this.last = last;
            this.sell = sell;
            this.buy = buy;
        }

        public String getId() {
            return id;
        }

        public String getLast15m() {
            return last15m;
        }

        public String getSymbol() {
            return symbol;
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
            return id + " " + symbol + " " + last + " " + last15m + " " + buy + " " + sell;
        }
    }
}