package ee.home.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class HistoricalPriceResponse {
   @JsonProperty (value = "bpi")
   private Map<String, Double> exchangeRates;
}
