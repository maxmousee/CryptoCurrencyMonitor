import com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.TextFormatter
import org.junit.Test
import org.junit.Assert.*

/**
 * Test text formatter - util class used to format text to be displayed by activities
 * Created by MaxMouse on 25/9/2017.
 */
class TextFormatterTest {

    @Test
    @Throws(Exception::class)
    fun shouldTruncateValue() {
        val someValue = 199.8829f
        val formattedCurrency = TextFormatter.formatCurrency(someValue)
        assertEquals(formattedCurrency, "199.88")
    }

    @Test
    @Throws(Exception::class)
    fun shouldDisplayRoundValue() {
        val someValue = 199f
        val formattedCurrency = TextFormatter.formatCurrency(someValue)
        assertEquals(formattedCurrency, "199.00")
    }

    @Test
    @Throws(Exception::class)
    fun shouldDisplayValueWith2Decimal() {
        val someValue = 199.11f
        val formattedCurrency = TextFormatter.formatCurrency(someValue)
        assertEquals(formattedCurrency, "199.11")
    }
}