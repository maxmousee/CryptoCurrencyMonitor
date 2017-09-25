package com.nfsindustries.cryptocurrencymonitor.utils

import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem

/**
 * Global constants
 * Created by MaxMouse on 18/9/2017.
 */
object Constants {

    /**
     * List of available Crypto Currencies
     */
    val CURR_ITEMS = listOf<CurrencyListItem>(CurrencyListItem("bitcoin", "bitcoin"),
            CurrencyListItem("zcash", "ZEC"), CurrencyListItem("dogecoin", "DOGE"),
            CurrencyListItem("ethereum", "ETH"), CurrencyListItem("ripple", "XRP"),
            CurrencyListItem("ethereum-classic", "ETC"), CurrencyListItem("litecoin", "LTC"),
            CurrencyListItem("nem", "NEM"), CurrencyListItem("dash", "DASH"),
            CurrencyListItem("monero", "XMR"), CurrencyListItem("bytecoin-bcn", "BCN"),
            CurrencyListItem("stellar", "XLM"), CurrencyListItem("golem-network-tokens", "GNT"),
            CurrencyListItem("gamecredits", "GAME"), CurrencyListItem("bitshares", "BTS"),
            CurrencyListItem("digixdao", "DGD"), CurrencyListItem("lisk", "LSK"),
            CurrencyListItem("augur", "REP"), CurrencyListItem("gnosis-gno", "GNO"),
            CurrencyListItem("stratis", "STRAT"), CurrencyListItem("waves", "WAVES"),
            CurrencyListItem("maidsafecoin", "MAID"), CurrencyListItem("digibyte", "DGB"),
            CurrencyListItem("factom", "FCT"), CurrencyListItem("bitconnect", "BCC"),
            CurrencyListItem("ardor", "ARDR"), CurrencyListItem("decred", "DCR"),
            CurrencyListItem("iconomi", "ICN"), CurrencyListItem("singulardtv", "SNGLS"),
            CurrencyListItem("omisego", "OMG"), CurrencyListItem("bitconnect", "BCC"),
            CurrencyListItem("qtum", "QTUM"), CurrencyListItem("tether", "USDT"),
            CurrencyListItem("ark", "ARK"), CurrencyListItem("tenx", "PAY"),
            CurrencyListItem("komodo", "KMD"), CurrencyListItem("hshare", "HSR"),
            CurrencyListItem("veritaseum", "VERI"), CurrencyListItem("bitcoindark", "BTCD"),
            CurrencyListItem("steem", "STEEM"), CurrencyListItem("siacoin", "SC"))

    /**
     * Cache size
     */
    val CACHE_SIZE = (10 * 1024 * 1024).toLong() // 10 MiB

    /**
     * Base URL for coin market cap
     */
    val COIN_MARKETCAP_BASE_URL = "https://api.coinmarketcap.com/v1/"

    /**
     * Path to convert bitcoin
     */
    val BITCOIN_CONVERT = "tobtc"

    /**
     * Path to convert bitcoin
     */
    val TICKER = "ticker"

    /**
     * Bitcoin intent extra - to get details of bitcoin index
     */
    val BITCOIN = "bitcoin"

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    val CURRENCY_NAME_KEY = "currencyName"

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    val CURRENCY_SYMBOL_KEY = "currencySymbol"

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    val ARG_ITEM_ID = "item_id"
}