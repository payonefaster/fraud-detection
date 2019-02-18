package pay.one.faster.fraud.http.domain.customer;

import java.util.HashSet;
import java.util.Set;

public class EnabledCountries {

  private Set<String> countries = new HashSet<>();

  public boolean isAbleToBuyIn(String country){
    return this.countries.contains(country);
  }

}
