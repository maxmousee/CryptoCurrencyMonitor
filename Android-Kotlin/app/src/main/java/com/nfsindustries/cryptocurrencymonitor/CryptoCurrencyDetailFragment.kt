package com.nfsindustries.cryptocurrencymonitor

import android.support.design.widget.CollapsingToolbarLayout
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel
import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.nfsindustries.cryptocurrencymonitor.utils.Constants.CURRENCY_NAME_KEY
import com.nfsindustries.cryptocurrencymonitor.utils.Constants.CURRENCY_SYMBOL_KEY
import com.nfsindustries.cryptocurrencymonitor.service.coinmarket.CoinmarketCapAPI

/**
 * A fragment representing a single CryptoCurrency detail screen.
 * This fragment is either contained in a [CryptoCurrencyListActivity]
 * in two-pane mode (on tablets) or a [CryptoCurrencyDetailActivity]
 * on handsets.
 */
class CryptoCurrencyDetailFragment : Fragment() {

    /**
     * The content this fragment is presenting.
     */
    private var mItem: CurrencyListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(CURRENCY_NAME_KEY) && arguments.containsKey(CURRENCY_SYMBOL_KEY)) {
            // Load the content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = CurrencyListItem(arguments.getString(CURRENCY_NAME_KEY)!!,
                    arguments.getString(CURRENCY_SYMBOL_KEY)!!)

            val activity = this.activity
            val appBarLayout = activity.findViewById<View>(R.id.toolbar_layout) as CollapsingToolbarLayout
            appBarLayout.title = mItem!!.name
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.cryptocurrency_detail, container, false)

        // Show the crypto currency index content as text in a TextView.
        if (mItem != null) {
            val coinmarketCapService = CoinmarketCapAPI.retrofit.create(CoinmarketCapAPI::class.java)
            val call = coinmarketCapService.getCurrentIndex(mItem!!.name)

            call.enqueue(object : Callback<CryptoCurrencyModel> {
                override fun onResponse(call: Call<CryptoCurrencyModel>, response: Response<CryptoCurrencyModel>) {
                    val cryptoDetailView = rootView.findViewById<TextView>(R.id.cryptocurrency_detail) as TextView
                    try {
                        cryptoDetailView.text = response.body()!!.toString()
                    } catch (exc: NullPointerException) {
                        Log.e("GETTING_RESPONSE", exc.toString())
                        cryptoDetailView.text = "ERROR GETTING RESPONSE FROM SERVER"
                    }

                }

                override fun onFailure(call: Call<CryptoCurrencyModel>, throwable: Throwable) {
                    val cryptoDetailView = rootView.findViewById<TextView>(R.id.cryptocurrency_detail) as TextView
                    val errorMsg = "Something went wrong, please check your internet connection." + "\n" +
                            "Error message: " + throwable.message
                    cryptoDetailView.text = errorMsg
                }
            })
        }
        return rootView
    }
}