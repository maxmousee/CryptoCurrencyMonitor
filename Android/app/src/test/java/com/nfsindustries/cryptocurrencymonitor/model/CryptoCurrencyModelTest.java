package com.nfsindustries.cryptocurrencymonitor.model;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by maxmo on 29/5/2017.
 */

public class CryptoCurrencyModelTest {

    @Test
    public void shouldInitialize() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        Assert.assertNotNull(cryptoCurrencyModel);
    }

    @Test
    public void shouldSetName() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setName("natan");
        Assert.assertEquals(cryptoCurrencyModel.getName(), "natan");
    }

    @Test
    public void shouldSetId() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setId("oneId");
        Assert.assertEquals(cryptoCurrencyModel.getId(), "oneId");
    }

    @Test
    public void shouldSetLastUpdated() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setLastUpdated(1239179L);
        Assert.assertEquals(cryptoCurrencyModel.getLastUpdated(), 1239179L);
    }

    @Test
    public void shouldSet24hVolumeUsd() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.set24hVolumeUsd(128.7f);
        Assert.assertEquals(cryptoCurrencyModel.get24hVolumeUsd(), 128.7f);
    }

    @Test
    public void shouldSetAvailableSupply() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setAvailableSupply(12877.7f);
        Assert.assertEquals(cryptoCurrencyModel.getAvailableSupply(), 12877.7f);
    }

    @Test
    public void shouldSetMarketCapUsd() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setMarketCapUsd(1299877.7f);
        Assert.assertEquals(cryptoCurrencyModel.getMarketCapUsd(), 1299877.7f);
    }

    @Test
    public void shouldSetPriceBtc() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setPriceBtc(9.12f);
        Assert.assertEquals(cryptoCurrencyModel.getPriceBtc(), 9.12f);
    }

    @Test
    public void shouldSetPriceUsd() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setPriceUsd(888.66f);
        Assert.assertEquals(cryptoCurrencyModel.getPriceUsd(), 888.66f);
    }

    @Test
    public void shouldSetSymbol() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setSymbol("BRL");
        Assert.assertEquals(cryptoCurrencyModel.getSymbol(), "BRL");
    }

    @Test
    public void shouldSetRank() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setRank(9);
        Assert.assertEquals(cryptoCurrencyModel.getRank(), 9);
    }

    @Test
    public void shouldSetPercent1h() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setPercentChange1h(9.1f);
        Assert.assertEquals(cryptoCurrencyModel.getPercentChange1h(), 9.1f);
    }

    @Test
    public void shouldSetPercent24h() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setPercentChange24h(7.4f);
        Assert.assertEquals(cryptoCurrencyModel.getPercentChange24h(), 7.4f);
    }

    @Test
    public void shouldSetPercent7d() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setPercentChange7d(69.01f);
        Assert.assertEquals(cryptoCurrencyModel.getPercentChange7d(), 69.01f);
    }

    @Test
    public void shouldSetTotalSupply() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setTotalSupply(912769.01f);
        Assert.assertEquals(cryptoCurrencyModel.getTotalSupply(), 912769.01f);
    }

    @Test
    public void shouldConvertToString() throws Exception {
        CryptoCurrencyModel cryptoCurrencyModel = new CryptoCurrencyModel();
        cryptoCurrencyModel.setName("DOGE");
        cryptoCurrencyModel.setPriceUsd(1.7788f);
        cryptoCurrencyModel.setPercentChange1h(1.02f);
        cryptoCurrencyModel.setPercentChange24h(2.0299f);
        cryptoCurrencyModel.setPercentChange7d(51.42f);
        Assert.assertEquals(cryptoCurrencyModel.toString(), "1 DOGE to USD\n" +
                "\n" + "Last: 1.78\n" + "\n" + "Change 1h: 1.02%\n" +
                "\n" + "Change 24h: 2.0299%\n" +
                "\n" + "Change 7d: 51.42%\n" + "\n");
    }
}
