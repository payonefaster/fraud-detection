package pay.one.faster.fraud.http.infra.web;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import pay.one.faster.fraud.http.domain.FraudAnalysisRequest;
import pay.one.faster.fraud.http.domain.FraudAnalysisResult;
import pay.one.faster.fraud.http.domain.FraudAnalysisService;
import reactor.core.publisher.Mono;

@Configuration
public class FraudAnalysisRouter {

  @Bean(name = "fraudAnalysisRouter")
  RouterFunction<ServerResponse> customerDataRouter(FraudAnalysisService fraudAnalysisService) {
    return route(
        POST("/api/fraud-analysis"),
        req -> {
          Mono<FraudAnalysisRequest> request = req.bodyToMono(FraudAnalysisRequest.class);
          final OpenTracingHeaders headers = new OpenTracingHeaders();
          OpenTracingHeaders.options.forEach(el -> headers.add(el,req.headers().header(el).get(0)));
          return created(UriComponentsBuilder.fromPath("/fraud-analysis/").build().toUri())
              .contentType(MediaType.APPLICATION_JSON)
              .body(
                  fromPublisher(
                      request
                          .map(p -> p)
                          .flatMap(
                              analysis -> fraudAnalysisService.analyze(analysis, headers)),
                      FraudAnalysisResult.class));
        });
  }
}
