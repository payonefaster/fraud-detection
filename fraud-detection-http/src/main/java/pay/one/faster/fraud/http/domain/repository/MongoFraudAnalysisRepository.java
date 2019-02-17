package pay.one.faster.fraud.http.domain.repository;

import org.springframework.stereotype.Service;
import pay.one.faster.fraud.http.domain.FraudAnalysisResult;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
@Service
public class MongoFraudAnalysisRepository implements FraudAnalysisRepository {

  private final ReactiveFraudAnalysisRepository fraudAnalysisRepository;

  public MongoFraudAnalysisRepository(ReactiveFraudAnalysisRepository fraudAnalysisRepository) {
    this.fraudAnalysisRepository = fraudAnalysisRepository;
  }

  @Override
  public Mono<FraudAnalysisResult> add(FraudAnalysisResult fraudAnalysis) {
    return this.fraudAnalysisRepository.save(fraudAnalysis);
  }

}
