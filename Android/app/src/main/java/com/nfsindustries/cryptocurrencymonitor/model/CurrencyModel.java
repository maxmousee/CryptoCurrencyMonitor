package com.nfsindustries.cryptocurrencymonitor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maxmouse on 18/5/2017.
 */

public class CurrencyModel {

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */

    /**
     * An array of currency items.
     */
    public static final List<CurrencyItem> ITEMS = new ArrayList<CurrencyItem>();

    /**
     * A map of currency items, by ID.
     */
    public static final Map<String, CurrencyItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 1;

    /**
     * Only supporting bitcoin for first version
     */

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCurrencyItem(i));
        }
    }

    private static void addItem(CurrencyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CurrencyItem createCurrencyItem(int position) {
        return new CurrencyItem(String.valueOf(position), "CurrencyName", makeBitcoinDetails(position), 1000, 1000, 999);
    }

    private static String makeBitcoinDetails(int position) {
        return "Bitcoin";
    }

    /**
     * A currency item representing a piece of content.
     */
    public static class CurrencyItem {
        public final String id;
        public final String name;
        public final String symbol;
        public final float last;
        public final float sell;
        public final float buy;

        public CurrencyItem(String id, String name, String symbol, float last, float sell, float buy) {
            this.id = id;
            this.name = name;
            this.symbol = symbol;
            this.last = last;
            this.sell = sell;
            this.buy = buy;
        }

        @Override
        public String toString() {
            return name + " " + symbol;
        }
    }
}