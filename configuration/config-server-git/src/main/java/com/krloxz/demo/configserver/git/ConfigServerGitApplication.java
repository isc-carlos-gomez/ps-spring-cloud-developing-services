package com.krloxz.demo.configserver.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerGitApplication {

  public static void main(final String[] args) {
    SpringApplication.run(ConfigServerGitApplication.class, args);
  }

}
