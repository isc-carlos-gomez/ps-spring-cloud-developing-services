package com.krloxz.demo.secureui;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

  @Autowired
  private OAuth2ClientContext clientContext;

  @Autowired
  private OAuth2RestTemplate oauth2RestTemplate;

  @GetMapping("/")
  public String loadHome() {
    return "home";
  }

  @GetMapping("/reports")
  public String loadReports(final Model model) {
    System.out.println("Token: " + this.clientContext.getAccessToken().getValue());

    final ResponseEntity<List<TollUsage>> tolls = this.oauth2RestTemplate.exchange(
        "http://localhost:9001/services/tolldata",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<TollUsage>>() {});
    model.addAttribute("tolls", tolls.getBody());

    return "reports";
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "/login**").permitAll()
        .anyRequest().authenticated();
  }

  public static class TollUsage {

    public String Id;
    public String stationId;
    public String licensePlate;
    public String timestamp;

    public TollUsage() {}

    public TollUsage(final String id, final String stationid, final String licenseplate,
        final String timestamp) {
      this.Id = id;
      this.stationId = stationid;
      this.licensePlate = licenseplate;
      this.timestamp = timestamp;
    }

  }

}
