package ee.home.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class HistoricalPriceResponse {
  private Map<String, Double> bpi;

   public Map<String, Double> getBpi() {
      return bpi;
   }
}
