package pay.one.faster.fraud.http.infra.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author claudioed on 2019-02-17.
 * Project fraud-detection
 */
@Configuration
public class WebClientProducer {

  @Bean
  public WebClient webClient(){
    return WebClient.builder().build();
  }

}
