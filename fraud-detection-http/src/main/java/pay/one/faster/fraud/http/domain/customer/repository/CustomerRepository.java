package pay.one.faster.fraud.http.domain.customer.repository;

import pay.one.faster.fraud.http.domain.customer.CustomerData;
import pay.one.faster.fraud.http.infra.web.OpenTracingHeaders;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
public interface CustomerRepository {

  Mono<CustomerData> customerData(String id, OpenTracingHeaders headers);

}
