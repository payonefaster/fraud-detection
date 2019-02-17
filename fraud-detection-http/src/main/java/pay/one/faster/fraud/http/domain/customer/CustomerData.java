package pay.one.faster.fraud.http.domain.customer;

public class CustomerData {

  private String id;

  private String name;

  private String email;

  private EnabledCountries enabledCountries = new EnabledCountries();

  private EnabledProvinces enabledProvinces = new EnabledProvinces();
}
