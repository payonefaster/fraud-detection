package pay.one.faster.fraud.http.infra.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author claudioed on 2019-02-17. Project fraud-detection */
public class OpenTracingHeaders {

  private final List<String> options =
      List.of(
          "x-request-id",
          "x-b3-traceid",
          "x-b3-spanid",
          "x-b3-parentspanid",
          "x-b3-sampled",
          "x-b3-flags",
          "x-ot-span-context");

  private final Map<String, String> headers = new HashMap<>();

  public OpenTracingHeaders add(String header, String value) {
    this.headers.put(header, value);
    return this;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

}
