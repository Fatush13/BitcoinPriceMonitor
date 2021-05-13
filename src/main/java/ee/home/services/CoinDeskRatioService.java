package ee.home.services;


import ee.home.utils.CurrencyCodeValidator;
import ee.home.utils.ResponseMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.requireNonNull;


@Slf4j
public class CoinDeskRatioService {

   /* dependencies */

  private static final CoinDeskClient client = new CoinDeskClient();

  /* methods */

   public static void processRequest(String currencyCode) {
      currencyCode = currencyCode.toUpperCase();

      if (CurrencyCodeValidator.checkCurrencyCode(currencyCode)) {
         try {
            getCurrentPrice(currencyCode);
            getHistoricalPrice(currencyCode);
         } catch (Exception e) {
            log.info("Could not retrieve data from Coin Desk");
         }
      }
   }

   /* implementation */

   private static void getCurrentPrice(String currencyCode) throws IOException {
      String response = requireNonNull(client.getCurrentRatio(currencyCode).body()).string();

      String ratio = ResponseMapper.toCurrentPrice(response).getBpi().get(currencyCode).getRate();

      log.info("Current exchange rate of Bitcoin to {} is 1 to {}", currencyCode, ratio);

   }

   private static void getHistoricalPrice(String currencyCode) throws IOException {
      String response = requireNonNull(client.getHistoricalRatio(currencyCode).body()).string();

      Collection<Double> bpiValues = ResponseMapper.toHistoricalPrice(response).getBpi().values();

      Double lowestRatio = Collections.min(bpiValues);

      Double highestRatio = Collections.max(bpiValues);

      log.info("During past 30 days the lowest exchange rate of Bitcoin to {} was 1 to {}",
           currencyCode, lowestRatio);
      log.info("During past 30 days the highest exchange rate of Bitcoin to {} was 1 to {}",
           currencyCode, highestRatio);
   }
}
