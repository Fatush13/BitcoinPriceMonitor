package ee.home.services;


import okhttp3.OkHttpClient;
import okhttp3.Request;

import lombok.SneakyThrows;

import static ee.home.constants.BTCServiceConstants.*;
import static java.util.Objects.*;


public class CoinDeskClient {
   OkHttpClient client = new OkHttpClient();

   @SneakyThrows
   protected String getCurrentRatio(String currencyCode){
      Request request =  new Request.Builder()
           .url(CURRENT_PRICE_URL.replace("#code", currencyCode))
           .build();

      return requireNonNull(client.newCall(request).execute().body()).string();
   }

   @SneakyThrows
   protected String getHistoricalRatio(String currencyCode) {
      Request request =  new Request.Builder()
           .url(PRICE_HISTORY_URL)
           .header(CURRENCY, currencyCode)
           .build();

      return requireNonNull(client.newCall(request).execute().body()).string();
   }
}

//{"time":{"updated":"May 12, 2021 16:09:00 UTC","updatedISO":"2021-05-12T16:09:00+00:00","updateduk":"May 12, 2021 at 17:09 BST"},
//     "disclaimer":"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
//     "bpi":{"USD":{"code":"USD","rate":"55,672.2772","description":"United States Dollar","rate_float":55672.2772},
//     "EUR":{"code":"EUR","rate":"46,111.6214","description":"Euro","rate_float":46111.6214}}}
