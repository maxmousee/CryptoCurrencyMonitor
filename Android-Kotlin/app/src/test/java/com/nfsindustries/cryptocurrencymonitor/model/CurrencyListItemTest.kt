import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem
import junit.framework.Assert
import org.junit.Test

/**
 * Created by MaxMouse on 25/9/2017.
 */

class CurrencyListItemTest {

    @Test
    @Throws(Exception::class)
    fun shouldInitAndSet() {
        val cryptocurrency = CurrencyListItem("bitcoin", "BTC")
        Assert.assertNotNull(cryptocurrency)
        Assert.assertNotNull(cryptocurrency.name)
        Assert.assertNotNull(cryptocurrency.symbol)
        Assert.assertEquals(cryptocurrency.name, "bitcoin")
        Assert.assertEquals(cryptocurrency.symbol, "BTC")
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvertToString() {
        val cryptocurrency = CurrencyListItem("dogecoin", "DOGE")
        Assert.assertNotNull(cryptocurrency)
        Assert.assertNotNull(cryptocurrency.name)
        Assert.assertNotNull(cryptocurrency.symbol)
        Assert.assertNotNull(cryptocurrency.toString())
    }
}