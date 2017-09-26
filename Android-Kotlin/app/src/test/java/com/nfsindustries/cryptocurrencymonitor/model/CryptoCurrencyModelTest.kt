import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel
import org.junit.Assert
import org.junit.Test

/**
 * Created by MaxMouse on 25/9/2017.
 */
class CryptoCurrencyModelTest {

    @Test
    @Throws(Exception::class)
    fun shouldInitialize() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        Assert.assertNotNull(cryptoCurrencyModel)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetName() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.name = "natan"
        Assert.assertEquals(cryptoCurrencyModel.name, "natan")
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetId() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.id = "oneId"
        Assert.assertEquals(cryptoCurrencyModel.id, "oneId")
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetLastUpdated() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.lastUpdated = 1239179L
        Assert.assertEquals(cryptoCurrencyModel.lastUpdated, 1239179L)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSet24hVolumeUsd() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.volumeUsd24h = 128.7f
        Assert.assertEquals(cryptoCurrencyModel.volumeUsd24h, 128.7f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetAvailableSupply() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.availableSupply = 12877.7f
        Assert.assertEquals(cryptoCurrencyModel.availableSupply, 12877.7f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetMarketCapUsd() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.marketCapUsd = 1299877.7f
        Assert.assertEquals(cryptoCurrencyModel.marketCapUsd, 1299877.7f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetPriceBtc() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.priceBtc = 9.12f
        Assert.assertEquals(cryptoCurrencyModel.priceBtc, 9.12f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetPriceUsd() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.priceUsd = 888.66f
        Assert.assertEquals(cryptoCurrencyModel.priceUsd, 888.66f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetSymbol() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.symbol = "BRL"
        Assert.assertEquals(cryptoCurrencyModel.symbol, "BRL")
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetRank() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.rank = 9
        Assert.assertEquals(cryptoCurrencyModel.rank, 9)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetPercent1h() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.percentChange1h = 9.1f
        Assert.assertEquals(cryptoCurrencyModel.percentChange1h, 9.1f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetPercent24h() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.percentChange24h = 7.4f
        Assert.assertEquals(cryptoCurrencyModel.percentChange24h, 7.4f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetPercent7d() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.percentChange7d = 69.01f
        Assert.assertEquals(cryptoCurrencyModel.percentChange7d, 69.01f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetTotalSupply() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.totalSupply = 912769.01f
        Assert.assertEquals(cryptoCurrencyModel.totalSupply, 912769.01f)
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvertToString() {
        val cryptoCurrencyModel = CryptoCurrencyModel()
        cryptoCurrencyModel.name = "DOGE"
        cryptoCurrencyModel.priceUsd = 1.7788f
        cryptoCurrencyModel.percentChange1h = 1.02f
        cryptoCurrencyModel.percentChange24h = 2.0299f
        cryptoCurrencyModel.percentChange7d = 51.42f
        Assert.assertEquals(cryptoCurrencyModel.toString(), "1 DOGE to USD\n" +
                "\n" + "Last: 1.78\n" + "\n" + "Change 1h: 1.02%\n" +
                "\n" + "Change 24h: 2.0299%\n" +
                "\n" + "Change 7d: 51.42%\n" + "\n")
    }
}