package ee.home;


import ee.home.services.CoinDeskClient;
import ee.home.services.CoinDeskRatioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;

import static ee.home.utils.CurrencyCodeValidator.checkCurrencyCode;


public class BTCMonitorTests extends Assertions {

   @Test
   void testCurrencyCodeValidation() {
      assertAll("Currency code validation",
           () -> assertTrue(checkCurrencyCode("USD")),
           () -> assertTrue(checkCurrencyCode("EUR")),
           () -> assertTrue(checkCurrencyCode("CZK")),
           () -> assertTrue(checkCurrencyCode("GBP")),
           () -> assertFalse(checkCurrencyCode("ASD")),
           () -> assertFalse(checkCurrencyCode("usd")),
           () -> assertFalse(checkCurrencyCode("KaRaKuLi")),
           () -> assertFalse(checkCurrencyCode("12353253")),
           () -> assertFalse(checkCurrencyCode("")),
           () -> assertFalse(checkCurrencyCode("   ")),
           () -> assertFalse(checkCurrencyCode("*&#!##%^*%#$"))
      );
   }

   @Test
   @SneakyThrows
   void testClientCurrentPriceCall() {
      CoinDeskClient client = new CoinDeskClient();
      assertAll("Currency code validation",
           () -> assertEquals(404, client.getCurrentRatio("asd").code(), "404"),
           () -> assertEquals(200, client.getCurrentRatio("usd").code(), "200")
      );
   }

   @Test
   @SneakyThrows
   void testClientHistoricalPriceCall() {
      CoinDeskClient client = new CoinDeskClient();
      assertAll("CoinDesk client calls",
           () -> assertFalse(client.getHistoricalRatio("ASD").body().string().contains("ASD"), "ASD"),
           () -> assertEquals(200, client.getHistoricalRatio("usd").code(), "200")
      );
   }

   @Test
   void testProcessRequest() {
      assertDoesNotThrow(() -> CoinDeskRatioService.processRequest("usd"), "success");
   }
}
