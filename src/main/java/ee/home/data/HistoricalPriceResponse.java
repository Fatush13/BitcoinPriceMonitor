package ee.home.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class HistoricalPriceResponse {
  private Map<String, Double> bpi;

   public Map<String, Double> getBpi() {
      return bpi;
   }
}
