package com.nfsindustries.cryptocurrencymonitor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * An activity representing a list of CryptoCurrencies. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CryptoCurrencyDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CryptoCurrencyListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private static final List<CurrencyListItem> CURRENCY_LIST_ITEMS = Arrays.asList(new CurrencyListItem("bitcoin", "BTC"),
            new CurrencyListItem("ethereum", "ETH"), new CurrencyListItem("ripple", "XRP"),
            new CurrencyListItem("ethereum-classic", "ETC"), new CurrencyListItem("litecoin", "LTC"),
            new CurrencyListItem("nem", "NEM"), new CurrencyListItem("dash", "DASH"),
            new CurrencyListItem("monero", "XMR"), new CurrencyListItem("bytecoin-bcn", "BCN"),
            new CurrencyListItem("stellar", "XLM"), new CurrencyListItem("golem-network-tokens", "GNT"),
            new CurrencyListItem("gamecredits", "GAME"), new CurrencyListItem("bitshares", "BTS"),
            new CurrencyListItem("digixdao", "DGD"), new CurrencyListItem("lisk", "LSK"),
            new CurrencyListItem("augur", "REP"), new CurrencyListItem("gnosis-gno", "GNO"),
            new CurrencyListItem("stratis", "STRAT"), new CurrencyListItem("waves", "WAVES"),
            new CurrencyListItem("zcash", "ZEC"), new CurrencyListItem("dogecoin", "DOGE"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptocurrency_list);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        final View recyclerView = findViewById(R.id.cryptocurrency_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.cryptocurrency_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(CURRENCY_LIST_ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<CurrencyListItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<CurrencyListItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cryptocurrency_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mSymbolView.setText(mValues.get(position).getSymbol());
            holder.mContentView.setText(mValues.get(position).getName());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        final Bundle arguments = new Bundle();
                        arguments.putString(Constants.ARG_ITEM_ID, holder.mItem.getName());
                        final CryptoCurrencyDetailFragment fragment = new CryptoCurrencyDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.cryptocurrency_detail_container, fragment)
                                .commit();
                    } else {
                        final Context context = v.getContext();
                        final Intent intent = new Intent(context, CryptoCurrencyDetailActivity.class);
                        intent.putExtra(Constants.CURRENCY_NAME_KEY, holder.mItem.getName());
                        intent.putExtra(Constants.CURRENCY_SYMBOL_KEY, holder.mItem.getSymbol());
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mSymbolView;
            public final TextView mContentView;
            public CurrencyListItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mSymbolView = (TextView) view.findViewById(R.id.currencySymbol);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
