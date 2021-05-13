package ee.home.services;


import ee.home.utils.CurrencyCodeValidator;
import ee.home.utils.ResponseMapper;

import java.util.Collection;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CoinDeskRatioService {
   CoinDeskClient client = new CoinDeskClient();

   public void getCurrentPrice(String currencyCode) {
      currencyCode = currencyCode.toUpperCase();

      if (CurrencyCodeValidator.checkCurrencyCode(currencyCode)) {
         String response = client.getCurrentRatio(currencyCode);

         String ratio = ResponseMapper.toCurrentPrice(response).getBpi().get(currencyCode).getRate();

         log.info("Current exchange rate of Bitcoin to " + currencyCode + " is 1 to " + ratio);
      }
   }

   public void getHistoricalPrice(String currencyCode) {
      currencyCode = currencyCode.toUpperCase();

      if (CurrencyCodeValidator.checkCurrencyCode(currencyCode)) {
         String response = client.getHistoricalRatio(currencyCode);

         Collection<Double> bpiValues = ResponseMapper.toHistoricalPrice(response).getBpi().values();

         Double lowestRatio = Collections.min(bpiValues);

         Double highestRatio = Collections.max(bpiValues);

         log.info("During past 30 days the lowest exchange rate of Bitcoin to " + currencyCode + " was 1 to " + lowestRatio);
         log.info("During past 30 days the highest exchange rate of Bitcoin to " + currencyCode + " was 1 to " + highestRatio);
      }
   }
}
