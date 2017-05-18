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
     * An array of sample (dummy) items.
     */
    public static final List<CurrencyItem> ITEMS = new ArrayList<CurrencyItem>();

    /**
     * A map of sample  items, by ID.
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
        return new CurrencyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A currency item representing a piece of content.
     */
    public static class CurrencyItem {
        public final String id;
        public final String content;
        public final String details;

        public CurrencyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}