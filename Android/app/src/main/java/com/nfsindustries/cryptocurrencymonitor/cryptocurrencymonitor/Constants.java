package com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor;

import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maxmo on 22/5/2017.
 */

public final class Constants {

    /**
     * List of available cryptocurrencies
     */
    public static final List<CurrencyListItem> CURRENCY_LIST_ITEMS = Arrays.asList(new CurrencyListItem("bitcoin", "BTC"),
            new CurrencyListItem("zcash", "ZEC"), new CurrencyListItem("dogecoin", "DOGE"),
            new CurrencyListItem("ethereum", "ETH"), new CurrencyListItem("ripple", "XRP"),
            new CurrencyListItem("ethereum-classic", "ETC"), new CurrencyListItem("litecoin", "LTC"),
            new CurrencyListItem("nem", "NEM"), new CurrencyListItem("dash", "DASH"),
            new CurrencyListItem("monero", "XMR"), new CurrencyListItem("bytecoin-bcn", "BCN"),
            new CurrencyListItem("stellar", "XLM"), new CurrencyListItem("golem-network-tokens", "GNT"),
            new CurrencyListItem("gamecredits", "GAME"), new CurrencyListItem("bitshares", "BTS"),
            new CurrencyListItem("digixdao", "DGD"), new CurrencyListItem("lisk", "LSK"),
            new CurrencyListItem("augur", "REP"), new CurrencyListItem("gnosis-gno", "GNO"),
            new CurrencyListItem("stratis", "STRAT"), new CurrencyListItem("waves", "WAVES"),
            new CurrencyListItem("maidsafecoin", "MAID"), new CurrencyListItem("digibyte", "DGB"),
            new CurrencyListItem("factom", "FCT"), new CurrencyListItem("bitconnect", "BCC"),
            new CurrencyListItem("ardor", "ARDR"), new CurrencyListItem("decred", "DCR"),
            new CurrencyListItem("iconomi", "ICN"), new CurrencyListItem("singulardtv", "SNGLS"),
            new CurrencyListItem("steem", "STEEM"), new CurrencyListItem("siacoin", "SC"));

    /**
     * Cache size
     */
    public static final long CACHE_SIZE = 10 * 1024 * 1024; // 10 MiB

    /**
     * Base URL for coin market cap
     */
    public static final String COIN_MARKETCAP_BASE_URL = "https://api.coinmarketcap.com/v1/";

    /**
     * Path to convert bitcoin
     */
    public static final String BITCOIN_CONVERT = "tobtc";

    /**
     * Path to convert bitcoin
     */
    public static final String TICKER = "ticker";

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
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
}
