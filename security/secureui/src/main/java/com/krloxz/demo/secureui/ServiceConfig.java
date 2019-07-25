package com.krloxz.demo.secureui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
public class ServiceConfig {

  @Bean
  public OAuth2RestTemplate auth2RestTemplate(
      final OAuth2ProtectedResourceDetails resource, final OAuth2ClientContext context) {
    return new OAuth2RestTemplate(resource, context);
  }

}
