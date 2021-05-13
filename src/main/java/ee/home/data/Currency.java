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
