package com.nfsindustries.cryptocurrencymonitor.service.bitcoin;

import com.nfsindustries.cryptocurrencymonitor.model.BitcoinModel;
import com.nfsindustries.cryptocurrencymonitor.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maxmo on 23/5/2017.
 */

public interface BitcoinAPI {

    @GET(Constants.BITCOIN_BASE_URL + Constants.BITCOIN_INDEX)
    Call<BitcoinModel> getCurrentIndex();
}
