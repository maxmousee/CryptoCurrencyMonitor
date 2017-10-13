package com.nfsindustries.cryptocurrencymonitor

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.nfsindustries.cryptocurrencymonitor.activity.CryptoCurrencyListActivity
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matchers.hasToString

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

    @get:Rule
    val mActivityRule: ActivityTestRule<CryptoCurrencyListActivity> = ActivityTestRule(CryptoCurrencyListActivity::class.java)

    @Test
    fun bitCoinIsDisplayedOnView() {
        onView(withId(R.id.cryptocurrency_list))
                .check(matches(hasDescendant(withText("bitcoin"))));
    }

    @Test
    fun dogeCoinIsDisplayedOnView() {
        onView(withId(R.id.cryptocurrency_list))
                .check(matches(hasDescendant(withText("dogecoin"))));
    }

    @Test
    fun ethIsDisplayedOnView() {
        onView(withId(R.id.cryptocurrency_list))
                .check(matches(hasDescendant(withText("ethereum"))));
    }

    @Test
    fun ethClassicIsDisplayedOnView() {
        onView(withId(R.id.cryptocurrency_list))
                .check(matches(hasDescendant(withText("ethereum-classic"))));
    }

    @Test
    fun zCashIsDisplayedOnView() {
        onView(withId(R.id.cryptocurrency_list))
                .check(matches(hasDescendant(withText("zcash"))));
    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.nfsindustries.cryptocurrencymonitor", appContext.packageName)
    }
}
