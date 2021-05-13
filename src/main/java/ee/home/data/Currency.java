package ee.home.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonIgnoreProperties (ignoreUnknown = true)
@NoArgsConstructor
public class Currency {
   private String rate;
}
// The highest Bitcoin rate in the last 30 days, in the requested currency happened on 2021-04-13 and was 1378282.6179
//The lowest Bitcoin rate in the last 30 days, in the requested currency happened on2021-04-25 and was 1049684.5286

//The highest Bitcoin rate in the last 30 days, in the requested currency happened on 2021-04-13 and was 63564.8333
//The lowest Bitcoin rate in the last 30 days, in the requested currency happened on2021-04-25 and was 49128.24