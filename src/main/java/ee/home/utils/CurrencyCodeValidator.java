package ee.home.utils;


import java.util.Currency;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CurrencyCodeValidator {

   public static boolean checkCurrencyCode(String currencyCode) {
     try {
        Currency.getInstance(currencyCode);
     } catch (Exception e) {
      log.error("Incorrect currency code. You can find a proper list of codes at https://en.wikipedia.org/wiki/ISO_4217");
        return false;
     }
      return true;
   }
}
