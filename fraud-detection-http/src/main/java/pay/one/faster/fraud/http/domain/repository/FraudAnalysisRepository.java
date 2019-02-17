package pay.one.faster.fraud.http.domain.repository;

import pay.one.faster.fraud.http.domain.FraudAnalysisResult;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
public interface FraudAnalysisRepository {

  Mono<FraudAnalysisResult> add(FraudAnalysisResult fraudAnalysis);

}
