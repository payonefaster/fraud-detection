package pay.one.faster.fraud.http.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pay.one.faster.fraud.http.domain.customer.Place;
import pay.one.faster.fraud.http.domain.order.Order;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
@Document(collection = "fraud-analysis")
public class FraudAnalysisResult {

  @Id
  private String id;

  private Order order;

  private Place place;

  private String result;

  public FraudAnalysisResult(){}

  public FraudAnalysisResult(String id, Order order,
      Place place, String result) {
    this.id = id;
    this.order = order;
    this.place = place;
    this.result = result;
  }

  public String getId() {
    return id;
  }

  public Order getOrder() {
    return order;
  }

  public Place getPlace() {
    return place;
  }

  public String getResult() {
    return result;
  }

  public static FraudAnalysisResult newApproved(String id, Order order,
      Place place){
    return new FraudAnalysisResult(id,order,place,"APPROVED");
  }

  public static FraudAnalysisResult newDeclined(String id, Order order,
      Place place){
    return new FraudAnalysisResult(id,order,place,"DECLINED");
  }

}
