package ee.home;


import ee.home.services.CoinDeskClient;
import ee.home.services.CoinDeskRatioService;
import picocli.CommandLine;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Application {
   public static void main(String[] args) {
      log.info("Please input 3-letter currency code");
      Scanner scanner = new Scanner(System.in);
      CoinDeskRatioService service = new CoinDeskRatioService();

      String currencyCode = scanner.nextLine();
      service.getCurrentPrice(currencyCode);
      service.getHistoricalPrice(currencyCode);
   }
}