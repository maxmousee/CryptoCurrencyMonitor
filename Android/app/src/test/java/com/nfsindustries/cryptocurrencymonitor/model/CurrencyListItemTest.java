package com.nfsindustries.cryptocurrencymonitor.model;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by maxmo on 29/5/2017.
 */

public class CurrencyListItemTest {

    @Test
    public void shouldInitAndSet() throws Exception {
        CurrencyListItem cryptocurrency = new CurrencyListItem("bitcoin", "BTC");
        Assert.assertNotNull(cryptocurrency);
        Assert.assertNotNull(cryptocurrency.getName());
        Assert.assertNotNull(cryptocurrency.getSymbol());
        Assert.assertEquals(cryptocurrency.getName(), "bitcoin");
        Assert.assertEquals(cryptocurrency.getSymbol(), "BTC");
    }

    @Test
    public void shouldConvertToString() throws Exception {
        CurrencyListItem cryptocurrency = new CurrencyListItem("dogecoin", "DOGE");
        Assert.assertNotNull(cryptocurrency);
        Assert.assertNotNull(cryptocurrency.getName());
        Assert.assertNotNull(cryptocurrency.getSymbol());
        Assert.assertNotNull(cryptocurrency.toString());
    }
}
