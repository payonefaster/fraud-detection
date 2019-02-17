package pay.one.faster.fraud.http.domain.customer.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import pay.one.faster.fraud.http.domain.customer.CustomerData;
import pay.one.faster.fraud.http.infra.web.OpenTracingHeaders;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
@Service
public class HttpCustomerRepository implements CustomerRepository {

  private final WebClient webClient;

  private final String customerSvc;

  public HttpCustomerRepository(WebClient webClient,
      @Value("${customer.svc}") String customerSvc) {
    this.webClient = webClient;
    this.customerSvc = customerSvc;
  }

  @Override
  public Mono<CustomerData> customerData(String id, OpenTracingHeaders headers) {
    final WebClient web = this.webClient.mutate().baseUrl(this.customerSvc).build();
    final RequestHeadersSpec<?> spec = web.get().uri("/api/customers/{id}", id);

    openTracing(spec);


    return null;
  }


  private RequestHeadersSpec<?> openTracing(RequestHeadersSpec<?> spec){


    return spec;
  }



}
