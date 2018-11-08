package com.nfsindustries.cryptocurrencymonitor.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.nfsindustries.cryptocurrencymonitor.utils.Constants
import com.nfsindustries.cryptocurrencymonitor.CryptoCurrencyDetailFragment
import com.nfsindustries.cryptocurrencymonitor.R

/**
 * An activity representing a single CryptoCurrency detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [CryptoCurrencyListActivity].
 */
class CryptoCurrencyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptocurrency_detail)
        val toolbar = findViewById<Toolbar>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
            arguments.putString(Constants.CURRENCY_NAME_KEY,
                    intent.getStringExtra(Constants.CURRENCY_NAME_KEY))
            arguments.putString(Constants.CURRENCY_SYMBOL_KEY,
                    intent.getStringExtra(Constants.CURRENCY_SYMBOL_KEY))
            val fragment = CryptoCurrencyDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.cryptocurrency_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(Intent(this.applicationContext, CryptoCurrencyListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}