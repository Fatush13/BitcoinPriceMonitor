package ee.home.services;


import ee.home.utils.CurrencyCodeValidator;
import ee.home.utils.ResponseMapper;

import java.util.Collection;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CoinDeskRatioService {
  static CoinDeskClient client = new CoinDeskClient();

   public static void processRequest(String currencyCode) {
      currencyCode = currencyCode.toUpperCase();

      if (CurrencyCodeValidator.checkCurrencyCode(currencyCode)) {
         getCurrentPrice(currencyCode);
         getHistoricalPrice(currencyCode);
      }
   }

   private static void getCurrentPrice(String currencyCode) {
         String response = client.getCurrentRatio(currencyCode);

         String ratio = ResponseMapper.toCurrentPrice(response).getBpi().get(currencyCode).getRate();

         log.info("Current exchange rate of Bitcoin to {} is 1 to {}", currencyCode, ratio);
   }

   private static void getHistoricalPrice(String currencyCode) {
         String response = client.getHistoricalRatio(currencyCode);

         Collection<Double> bpiValues = ResponseMapper.toHistoricalPrice(response).getBpi().values();

         Double lowestRatio = Collections.min(bpiValues);

         Double highestRatio = Collections.max(bpiValues);

         log.info("During past 30 days the lowest exchange rate of Bitcoin to {} was 1 to {}", currencyCode, lowestRatio);
         log.info("During past 30 days the highest exchange rate of Bitcoin to {} was 1 to {}", currencyCode, highestRatio);
   }
}
