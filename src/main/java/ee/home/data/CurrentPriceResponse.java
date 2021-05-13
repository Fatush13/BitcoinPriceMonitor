package ee.home.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class CurrentPriceResponse {
   private Map<String, Currency> bpi;
}
