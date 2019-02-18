package pay.one.faster.fraud.http.domain;

import pay.one.faster.fraud.http.domain.customer.Customer;
import pay.one.faster.fraud.http.domain.order.Order;
import pay.one.faster.fraud.http.domain.customer.Place;

public class FraudAnalysisRequest {

  private Place place;

  private Order order;

  private Customer customer;

  public void setPlace(Place place) {
    this.place = place;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Place getPlace() {
    return place;
  }

  public Order getOrder() {
    return order;
  }

  public Customer getCustomer() {
    return customer;
  }
}
