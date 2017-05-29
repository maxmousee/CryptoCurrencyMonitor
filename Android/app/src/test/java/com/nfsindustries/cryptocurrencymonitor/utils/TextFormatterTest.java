package com.nfsindustries.cryptocurrencymonitor.utils;

import com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.TextFormatter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maxmo on 26/5/2017.
 */

public class TextFormatterTest {

    @Test
    public void shouldTruncateValue() throws Exception {
        float someValue = 199.8829f;
        String formattedCurrency = TextFormatter.formatCurrency(someValue);
        assertEquals(formattedCurrency, "199.88");
    }

    @Test
    public void shouldDisplayRoundValue() throws Exception {
        float someValue = 199;
        String formattedCurrency = TextFormatter.formatCurrency(someValue);
        assertEquals(formattedCurrency, "199.00");
    }

    @Test
    public void shouldDisplayValueWith2Decimal() throws Exception {
        float someValue = 199.11f;
        String formattedCurrency = TextFormatter.formatCurrency(someValue);
        assertEquals(formattedCurrency, "199.11");
    }
}
