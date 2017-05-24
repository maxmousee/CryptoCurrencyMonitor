package com.nfsindustries.cryptocurrencymonitor.utils;

/**
 * Created by maxmo on 22/5/2017.
 */

public final class Constants {

    /**
     * For more information about blockchain API, check https://blockchain.info/api/exchange_rates_api
     */

    /**
     * Base URL for bitcoin
     */
    public static final String BITCOIN_BASE_URL = "https://blockchain.info/";

    /**
     * Path to convert bitcoin
     */
    public static final String BITCOIN_CONVERT = "tobtc";

    /**
     * Path to convert bitcoin
     */
    public static final String BITCOIN_INDEX = "ticker";

    /**
     * Bitcoin intent extra - to get details of bitcoin index
     */
    public static final String BITCOIN_EXTRA = "bitcoin";

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    public static final String CURRENCY_NAME_KEY = "currencyName";

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
}
