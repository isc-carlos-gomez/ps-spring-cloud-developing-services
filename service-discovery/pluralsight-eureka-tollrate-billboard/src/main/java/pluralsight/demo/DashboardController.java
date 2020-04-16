package pluralsight.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class DashboardController {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate(final RestTemplateBuilder builder) {
    return builder.build();
  }

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "GetTollRateFallback")
  @RequestMapping("/dashboard")
  public String GetTollRate(@RequestParam final int stationId, final Model m) {

    final TollRate tr = this.restTemplate
        .getForObject("http://pluralsight-tollrate-service/tollrate/" + stationId, TollRate.class);
    System.out.println("stationId: " + stationId);
    m.addAttribute("rate", tr.getCurrentRate());
    return "dashboard";
  }

  @SuppressWarnings("unused")
  private String GetTollRateFallback(@RequestParam final int stationId, final Model m) {
    System.out.println("Fallback method invoked");
    m.addAttribute("rate", BigDecimal.ONE);
    return "dashboard";
  }
}
