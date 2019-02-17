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

}
