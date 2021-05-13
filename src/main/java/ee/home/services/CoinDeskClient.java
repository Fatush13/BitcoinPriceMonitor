package ee.home.services;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static ee.home.constants.BTCServiceConstants.CURRENCY;
import static ee.home.constants.BTCServiceConstants.CURRENT_PRICE_URL;
import static ee.home.constants.BTCServiceConstants.PRICE_HISTORY_URL;


public class CoinDeskClient {

   /* dependencies */

   OkHttpClient client = new OkHttpClient();

   /* methods */

   public Response getCurrentRatio(String currencyCode) throws IOException {
      Request request =  new Request.Builder()
           .url(CURRENT_PRICE_URL.replace("#code", currencyCode))
           .build();

      return client.newCall(request).execute();
   }

   public Response getHistoricalRatio(String currencyCode) throws IOException {
      Request request =  new Request.Builder()
           .url(PRICE_HISTORY_URL)
           .header(CURRENCY, currencyCode)
           .build();

      return client.newCall(request).execute();
   }
}