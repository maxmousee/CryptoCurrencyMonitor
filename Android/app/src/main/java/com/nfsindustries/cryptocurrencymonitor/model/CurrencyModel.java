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

    private static final int COUNT = 25;

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
        return new CurrencyItem(String.valueOf(position), "Item " + position, makeDetails(position), position * 10);
    }

    private static String makeDetails(int position) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\nMore details information here.");
        return builder.toString();
    }

    /**
     * A currency item representing a piece of content.
     */
    public static class CurrencyItem {
        public final String id;
        public final String content;
        public final String details;
        public final float last;

        public CurrencyItem(String id, String content, String details, float last) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.last = last;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}