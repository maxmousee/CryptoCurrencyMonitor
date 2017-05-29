package com.nfsindustries.cryptocurrencymonitor;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nfsindustries.cryptocurrencymonitor.model.CryptoCurrencyModel;
import com.nfsindustries.cryptocurrencymonitor.model.CurrencyListItem;
import com.nfsindustries.cryptocurrencymonitor.service.bitcoin.CoinmarketCapAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.Constants.CURRENCY_NAME_KEY;
import static com.nfsindustries.cryptocurrencymonitor.cryptocurrencymonitor.Constants.CURRENCY_SYMBOL_KEY;

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
    private CurrencyListItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CryptoCurrencyDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(CURRENCY_NAME_KEY) && getArguments().containsKey(CURRENCY_SYMBOL_KEY)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = new CurrencyListItem(getArguments().getString(CURRENCY_NAME_KEY),
                    getArguments().getString(CURRENCY_SYMBOL_KEY));

            final Activity activity = this.getActivity();
            final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.cryptocurrency_detail, container, false);

        // Show the crypto currency index content as text in a TextView.
        if (mItem != null) {
            final CoinmarketCapAPI coinmarketCapService = CoinmarketCapAPI.retrofit.create(CoinmarketCapAPI.class);
            final Call<CryptoCurrencyModel> call =
                    coinmarketCapService.getCurrentIndex(mItem.getName());

            call.enqueue(new Callback<CryptoCurrencyModel>() {
                @Override
                public void onResponse(final Call<CryptoCurrencyModel> call, final Response<CryptoCurrencyModel> response) {
                    final TextView cryptoDetailView = ((TextView) rootView.findViewById(R.id.cryptocurrency_detail));
                    try {
                        cryptoDetailView.setText(response.body().toString());
                    } catch (NullPointerException exc) {
                        Log.e("GETTING_RESPONSE", exc.toString());
                        cryptoDetailView.setText("ERROR GETTING RESPONSE FROM SERVER");
                    }

                }
                @Override
                public void onFailure(final Call<CryptoCurrencyModel> call, final Throwable throwable) {
                    final TextView cryptoDetailView = ((TextView) rootView.findViewById(R.id.cryptocurrency_detail));
                    final String errorMsg = "Something went wrong, please check your internet connection." + "\n" +
                            "Error message: " + throwable.getMessage();
                    cryptoDetailView.setText(errorMsg);
                }
            });
        }
        return rootView;
    }
}
