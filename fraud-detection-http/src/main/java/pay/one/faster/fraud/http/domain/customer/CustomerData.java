package pay.one.faster.fraud.http.domain.customer;

public class CustomerData {

  private String id;

  private String name;

  private String email;

  private EnabledCountries enabledCountries = new EnabledCountries();

  private EnabledProvinces enabledProvinces = new EnabledProvinces();

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public EnabledCountries getEnabledCountries() {
    return enabledCountries;
  }

  public EnabledProvinces getEnabledProvinces() {
    return enabledProvinces;
  }

  public boolean isAbleToBuyIn(Place place){
    final boolean ableToBuy =
        this.enabledCountries.isAbleToBuyIn(place.getCountry()) && this.enabledProvinces
            .isAbleToBuyIn(place.getProvince());
    if(!ableToBuy){
      throw new RuntimeException("Customer can't buy in " + place.getCountry());
    }
    return true;
  }

}
