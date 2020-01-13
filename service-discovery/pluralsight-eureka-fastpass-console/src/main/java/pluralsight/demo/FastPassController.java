package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FastPassController {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate(final RestTemplateBuilder builder) {
    return builder.build();
  }

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(path = "/customerdetails", params = {"fastpassid"})
  public String getFastPassCustomerDetails(@RequestParam final String fastpassid, final Model m) {

    final FastPassCustomer c = this.restTemplate.getForObject(
        "http://pluralsight-fastpass-service/fastpass?fastpassid=" + fastpassid,
        FastPassCustomer.class);
    System.out.println("retrieved customer details");
    m.addAttribute("customer", c);
    return "console";
  }

}
