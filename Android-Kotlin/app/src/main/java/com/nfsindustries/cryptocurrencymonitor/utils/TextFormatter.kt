package com.nfsindustries.cryptocurrencymonitor.utils

/**
 * Static class used to format text, strings and currencies to display
 */

object TextFormatter {

    /**
     * Format currency to display with only 2 decimal places
     * @param value currency value
     * @return formatted String to display
     */
    fun formatCurrency(value: Float): String {
        return String.format("%.2f", value)
    }
}
