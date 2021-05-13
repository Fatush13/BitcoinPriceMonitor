package ee.home;


import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

import static ee.home.constants.BTCServiceConstants.EXIT;
import static ee.home.services.CoinDeskRatioService.processRequest;


@Slf4j
public class Application {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      while (true) {
         log.info("\nPlease input a desired currency code or \"exit\" to discontinue");

         String currencyCode = scanner.nextLine();

         if (currencyCode.trim().equalsIgnoreCase(EXIT)) {
            break;
         }
         processRequest(currencyCode);
      }
      scanner.close();
   }
}