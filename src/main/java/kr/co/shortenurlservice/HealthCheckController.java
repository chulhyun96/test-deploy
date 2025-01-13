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
    // 용도 -> 엔진엑스 서버가 blue랑 연결되어있는 상태에서 green이 켜지면 옮겨준다거나
    // 서버의 상태가 잘 돌아가고 있는지 확인용
    Map<String, String> responseData = new TreeMap<>();
    responseData.put("env", env);
    responseData.put("serverAddress", serverAddress);
    responseData.put("name","shortenUrlService");
    responseData.put("serverName",serverName);
    responseData.put("port",port);
    return ResponseEntity.ok(responseData);
  }

  @GetMapping("/env")
  public ResponseEntity<?> getEnv() {
    return ResponseEntity.ok(env);
  }

}
