package com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor;

/**
 * Created by maxmo on 26/5/2017.
 */

public final class TextFormatter {

    /**
     * Format currency to display with only 2 decimal places
     * @param value currency value
     * @return formatted String to display
     */
    public static final String formatCurrency(final float value) {
        return String.format("%.2f", value);
    }
}
