package com.krloxz.demo.securecli;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SecurecliApplication implements CommandLineRunner {

  public static void main(final String[] args) {
    SpringApplication.run(SecurecliApplication.class, args);
  }

  @Override
  public void run(final String... args) throws Exception {

    System.out.println("Starting cron job");

    final ResourceOwnerPasswordResourceDetails resourceDetails =
        new ResourceOwnerPasswordResourceDetails();
    resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
    resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
    resourceDetails.setScope(Arrays.asList("toll_read"));
    resourceDetails.setClientId("pluralsight");
    resourceDetails.setClientSecret("secret");
    resourceDetails.setUsername("user1");
    resourceDetails.setPassword("password1");

    final OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
    System.out.println("Token: " + template.getAccessToken());

    final String result =
        template.getForObject("http://localhost:9001/services/tolldata", String.class);
    System.out.println("Result: " + result);
  }

}
