package com.nfsindustries.cryptocurrencymonitor.utils

import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem

/**
 * Global constants
 * Created by MaxMouse on 18/9/2017.
 */
object Constants {

    /**
     * List of available Crypto Currencies [static list]
     */
    //TODO get list of available currencies from server
    val CURR_ITEMS = listOf<CurrencyListItem>(CurrencyListItem("bitcoin", "bitcoin"), CurrencyListItem("bitcoin-cash", "BCH"),
            CurrencyListItem("zcash", "ZEC"), CurrencyListItem("dogecoin", "DOGE"), CurrencyListItem("ethereum", "ETH"), CurrencyListItem("ripple", "XRP"),
            CurrencyListItem("ethereum-classic", "ETC"), CurrencyListItem("litecoin", "LTC"), CurrencyListItem("nem", "NEM"), CurrencyListItem("dash", "DASH"),
            CurrencyListItem("neo", "NEO"), CurrencyListItem("iota", "MIOTA"), CurrencyListItem("pinkdog", "PDG"), CurrencyListItem("eggcoin", "EGG"),
            CurrencyListItem("karmacoin", "KARMA"), CurrencyListItem("0x", "ZRX"), CurrencyListItem("monero", "XMR"), CurrencyListItem("bytecoin-bcn", "BCN"),
            CurrencyListItem("stellar", "XLM"), CurrencyListItem("golem-network-tokens", "GNT"), CurrencyListItem("gamecredits", "GAME"),
            CurrencyListItem("bitshares", "BTS"), CurrencyListItem("digixdao", "DGD"), CurrencyListItem("lisk", "LSK"), CurrencyListItem("augur", "REP"),
            CurrencyListItem("gnosis-gno", "GNO"), CurrencyListItem("stratis", "STRAT"), CurrencyListItem("waves", "WAVES"), CurrencyListItem("maidsafecoin", "MAID"),
            CurrencyListItem("digibyte", "DGB"), CurrencyListItem("factom", "FCT"), CurrencyListItem("bitconnect", "BCC"), CurrencyListItem("ardor", "ARDR"),
            CurrencyListItem("decred", "DCR"), CurrencyListItem("iconomi", "ICN"), CurrencyListItem("singulardtv", "SNGLS"), CurrencyListItem("omisego", "OMG"),
            CurrencyListItem("bitconnect", "BCC"), CurrencyListItem("qtum", "QTUM"), CurrencyListItem("tether", "USDT"), CurrencyListItem("ark", "ARK"),
            CurrencyListItem("tenx", "PAY"), CurrencyListItem("komodo", "KMD"), CurrencyListItem("hshare", "HSR"), CurrencyListItem("veritaseum", "VERI"),
            CurrencyListItem("bitcoindark", "BTCD"), CurrencyListItem("steem", "STEEM"), CurrencyListItem("siacoin", "SC"))


    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    val CURRENCY_NAME_KEY = "currencyName"

    /**
     * Currency intent extra key - to get details of a given crypto currency index
     */
    val CURRENCY_SYMBOL_KEY = "currencySymbol"
}