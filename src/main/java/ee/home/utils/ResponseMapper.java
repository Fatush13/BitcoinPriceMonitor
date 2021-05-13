package ee.home.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import ee.home.data.CurrentPriceResponse;
import ee.home.data.HistoricalPriceResponse;

import lombok.SneakyThrows;


public class ResponseMapper {
  static ObjectMapper mapper = new ObjectMapper();

   @SneakyThrows
   public static CurrentPriceResponse toCurrentPrice(String response) {
      return mapper.readValue(response, CurrentPriceResponse.class);
   }

   @SneakyThrows
   public static HistoricalPriceResponse toHistoricalPrice(String response) {
      return mapper.readValue(response, HistoricalPriceResponse.class);
   }
}
