package pay.one.faster.fraud.domain.repository;

import pay.one.faster.fraud.domain.customer.CustomerData;

/**
 * @author claudioed on 2019-02-02.
 * Project fraud-detection
 */
public interface CustomerRepository {

  CustomerData customerData(String id);

}
