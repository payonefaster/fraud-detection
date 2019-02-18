package pay.one.faster.fraud.http.domain;

import java.util.UUID;
import org.springframework.stereotype.Service;
import pay.one.faster.fraud.http.domain.customer.repository.CustomerRepository;
import pay.one.faster.fraud.http.domain.repository.FraudAnalysisRepository;
import pay.one.faster.fraud.http.infra.web.OpenTracingHeaders;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-02.
 * Project fraud-detection-http
 */
@Service
public class FraudAnalysisService {

  private final CustomerRepository customerRepository;

  private final FraudAnalysisRepository fraudAnalysisRepository;

  public FraudAnalysisService(CustomerRepository customerRepository,
      FraudAnalysisRepository fraudAnalysisRepository) {
    this.customerRepository = customerRepository;
    this.fraudAnalysisRepository = fraudAnalysisRepository;
  }

  public Mono<FraudAnalysisResult> analyze(FraudAnalysisRequest request, OpenTracingHeaders headers){
    return this.customerRepository.customerData(request.getCustomer().getId(),headers)
    .flatMap(customerData -> { customerData.isAbleToBuyIn(request.getPlace());
      return Mono.just(customerData);
    }).flatMap(customerData -> Mono.just(FraudAnalysisResult.newApproved(UUID.randomUUID().toString(),request.getOrder(),request.getPlace())))
      .onErrorReturn(FraudAnalysisResult.newDeclined(UUID.randomUUID().toString(),request.getOrder(),request.getPlace()))
      .flatMap(this.fraudAnalysisRepository::add);
  }

}
