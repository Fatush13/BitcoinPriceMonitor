package ee.home.constants;


import okhttp3.MediaType;


public class BTCServiceConstants {

   public static final String CURRENCY = "currency";
   public static final String EXIT = "exit";
   public static final String COINDESK_BASEURL = "https://api.coindesk.com/v1/bpi/";
   public static final String CURRENT_PRICE_URL = COINDESK_BASEURL.concat("currentprice/#code.json");
   public static final String PRICE_HISTORY_URL =  COINDESK_BASEURL.concat("historical/close.json"); //https://api.coindesk.com/v1/bpi/historical/close.json?start=2021-01-01&end=2021-01-31&currency=eur
}
