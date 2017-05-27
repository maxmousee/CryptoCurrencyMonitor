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
    public static final String BLOCKCHAIN_BASE_URL = "https://blockchain.info/";

    /**
     * Base URL for coin market cap
     */
    public static final String COIN_MARKETCAP_BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";

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
    public static final String BITCOIN = "bitcoin";

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    public static final String CURRENCY_NAME_KEY = "currencyName";

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    public static final String CURRENCY_SYMBOL_KEY = "currencySymbol";

    /**
     * USA Dollar Currency Key
     */
    public static final String USD_KEY = "USD";

    /**
     * Bitcoin Currency Key
     */
    public static final String BTC_KEY = "BTC";

    /**
     * Bitcoin Last Index Key
     */
    public static final String LAST_KEY = "last";

    /**
     * Bitcoin Last 15m Index Key
     */
    public static final String LAST_15M_KEY = "15m";

    /**
     * Currency Symbol Key
     */
    public static final String SYMBOL_KEY = "symbol";

    /**
     * Buy Key
     */
    public static final String BUY_KEY = "buy";

    /**
     * Sell Key
     */
    public static final String SELL_KEY = "sell";

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
}
