package com.nfsindustries.cryptocurrencymonitor;

import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Bitcoin model unit tests
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BitcoinModelUnitTest {

    @Test
    public void init_isCorrect() throws Exception {
        BitcoinModel bitcoinModel = new BitcoinModel("US$", "btc", "chf", 900, 910, 899, 901);
        assertEquals(bitcoinModel.getBuy(), 901, 0);
        assertEquals(bitcoinModel.getLast15m(), 900, 0);
        assertEquals(bitcoinModel.getLast(), 910, 0);
        assertEquals(bitcoinModel.getSell(), 899, 0);
        assertEquals(bitcoinModel.getDestinationCurrency(), "chf");
        assertEquals(bitcoinModel.getDestinationSymbol(), "US$");
    }
}