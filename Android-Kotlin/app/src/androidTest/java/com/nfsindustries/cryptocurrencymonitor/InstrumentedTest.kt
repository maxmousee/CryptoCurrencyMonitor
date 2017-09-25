package com.nfsindustries.cryptocurrencymonitor

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.nfsindustries.cryptocurrencymonitor.activity.CryptoCurrencyListActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @Rule
    var mActivityRule: ActivityTestRule<CryptoCurrencyListActivity> = ActivityTestRule(CryptoCurrencyListActivity::class.java)

    @Test
    fun bitcoinIsDisplayedOnView() {
        onView(withText("bitcoin")).check(matches(isDisplayed()))
        onView(withText("dogecoin")).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.nfsindustries.cryptocurrencymonitor", appContext.packageName)
    }
}
