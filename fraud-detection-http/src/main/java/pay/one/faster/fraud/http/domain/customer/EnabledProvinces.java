package pay.one.faster.fraud.http.domain.customer;

import java.util.HashSet;
import java.util.Set;

public class EnabledProvinces {

  private Set<String> provinces = new HashSet<>();

  public boolean isAbleToBuyIn(String province){
    return this.provinces.contains(province);
  }

}
