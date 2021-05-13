package ee.home.constants;


public class BTCServiceConstants {
   public static final String CURRENCY = "currency";
   public static final String EXIT = "exit";
   public static final String COINDESK_BASEURL = "https://api.coindesk.com/v1/bpi/";
   public static final String CURRENT_PRICE_URL = COINDESK_BASEURL.concat("currentprice/#code.json");
   public static final String PRICE_HISTORY_URL =  COINDESK_BASEURL.concat("historical/close.json?currency=#code");
}
