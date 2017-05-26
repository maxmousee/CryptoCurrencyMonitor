package com.nfsindustries.cryptocurrencymonitor;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nfsindustries.cryptocurrencymonitor.deserializer.BitcoinIndexDeserializer;
import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;
import com.nfsindustries.cryptocurrencymonitor.model.CurrencyModel;
import com.nfsindustries.cryptocurrencymonitor.service.bitcoin.BitcoinAPI;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a single CryptoCurrency detail screen.
 * This fragment is either contained in a {@link CryptoCurrencyListActivity}
 * in two-pane mode (on tablets) or a {@link CryptoCurrencyDetailActivity}
 * on handsets.
 */
public class CryptoCurrencyDetailFragment extends Fragment {

    /**
     * The dummy content this fragment is presenting.
     */
    private CurrencyModel.CurrencyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CryptoCurrencyDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.CURRENCY_NAME_KEY)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            final Object currencyKey = CurrencyModel.ITEM_MAP.keySet().toArray()[0];
            mItem = CurrencyModel.ITEM_MAP.get(currencyKey);

            final Activity activity = this.getActivity();
            final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.symbol);
            }
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.cryptocurrency_detail, container, false);

        // Show the crypto currency index content as text in a TextView.
        if (mItem != null) {
            final BitcoinAPI bitcoinService = BitcoinAPI.blockchainRetrofit.create(BitcoinAPI.class);
            final Call<BitcoinModel> call =
                    bitcoinService.getCurrentIndex();

            call.enqueue(new Callback<BitcoinModel>() {
                @Override
                public void onResponse(final Call<BitcoinModel> call, final Response<BitcoinModel> response) {
                    final TextView cryptoDetailView = ((TextView) rootView.findViewById(R.id.cryptocurrency_detail));
                    cryptoDetailView.setText(response.body().toString());
                }
                @Override
                public void onFailure(final Call<BitcoinModel> call, final Throwable throwable) {
                    final TextView cryptoDetailView = ((TextView) rootView.findViewById(R.id.cryptocurrency_detail));
                    cryptoDetailView.setText("Something went wrong, please check your internet connection.");
                    cryptoDetailView.setText("Error message: " + throwable.getMessage());
                }
            });
        }
        return rootView;
    }
}
