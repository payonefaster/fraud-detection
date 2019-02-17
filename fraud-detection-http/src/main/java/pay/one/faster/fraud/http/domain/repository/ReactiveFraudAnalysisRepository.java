package pay.one.faster.fraud.http.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pay.one.faster.fraud.http.domain.FraudAnalysisResult;

/** @author claudioed on 2019-02-17. Project fraud-detection */
public interface ReactiveFraudAnalysisRepository
    extends ReactiveCrudRepository<FraudAnalysisResult, String> {}
