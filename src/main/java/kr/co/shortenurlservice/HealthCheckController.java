package kr.co.shortenurlservice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @Value("${server.env}")
  private String env;

  @Value("${server.port}")
  private String port;

  @Value("${server.serverAddress}")
  private String serverAddress;

  @Value("${serverName}")
  private String serverName;



  @GetMapping("/hc")
  public ResponseEntity<?> healthCheck() {
    Map<String, String> responseData = new TreeMap<>();
    responseData.put("env", env);
    responseData.put("serverAddress", serverAddress);
    responseData.put("name","shortenUrlService");
    responseData.put("serverName",serverName);
    responseData.put("port",port);
    if (env.equals("blue")) {
      responseData.put("status", "BLUE");
    } else {
      responseData.put("status", "GREEN");
    }
    return ResponseEntity.ok(responseData);
  }

  @GetMapping("/env")
  public ResponseEntity<?> getEnv() {
    return ResponseEntity.ok(env);
  }

}
