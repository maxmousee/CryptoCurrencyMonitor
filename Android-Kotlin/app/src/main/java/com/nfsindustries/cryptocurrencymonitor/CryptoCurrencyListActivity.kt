package com.nfsindustries.cryptocurrencymonitor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem

/**
 * An activity representing a list of CryptoCurrencies. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CryptoCurrencyDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */

class CryptoCurrencyListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptocurrency_list)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

        val recyclerView = findViewById<View>(R.id.cryptocurrency_list)!!
        setupRecyclerView((recyclerView as RecyclerView)!!)

        if (findViewById<View>(R.id.cryptocurrency_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setAdapter(SimpleItemRecyclerViewAdapter(Constants.CURR_ITEMS))
    }

    inner class SimpleItemRecyclerViewAdapter(private val mValues: List<CurrencyListItem>) :
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.cryptocurrency_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.mItem = mValues[position]
            holder.mSymbolView.text = mValues[position].symbol
            holder.mContentView.text = mValues[position].name

            holder.mView.setOnClickListener { v ->
                if (mTwoPane) {
                    val arguments = Bundle()
                    arguments.putString(Constants.ARG_ITEM_ID, holder.mItem!!.name)
                    /*
                    val fragment = CryptoCurrencyDetailFragment()
                    fragment.setArguments(arguments)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.cryptocurrency_detail_container, fragment)
                            .commit()
                            */
                } else {
                    val context = v.context
                    /*
                    val intent = Intent(context, CryptoCurrencyDetailActivity::class.java)
                    intent.putExtra(Constants.CURRENCY_NAME_KEY, holder.mItem!!.name)
                    intent.putExtra(Constants.CURRENCY_SYMBOL_KEY, holder.mItem!!.symbol)
                    context.startActivity(intent)
                    */
                }
            }
        }

        override fun getItemCount(): Int {
            return mValues.size
        }

        inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            val mSymbolView: TextView
            val mContentView: TextView
            var mItem: CurrencyListItem? = null

            init {
                mSymbolView = mView.findViewById<View>(R.id.currencySymbol) as TextView
                mContentView = mView.findViewById<View>(R.id.content) as TextView
            }

            override fun toString(): String {
                return super.toString() + " '" + mContentView.text + "'"
            }
        }
    }
}