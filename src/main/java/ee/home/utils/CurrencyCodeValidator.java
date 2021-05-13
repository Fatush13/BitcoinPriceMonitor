package ee.home.utils;


import java.util.Currency;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CurrencyCodeValidator {

   public static boolean checkCurrencyCode(String currencyCode) {
     try {
        Currency.getInstance(currencyCode);
     } catch (Exception e) {
      log.error("Incorrect currency code");
        return false;
     }
      return true;
   }
}
