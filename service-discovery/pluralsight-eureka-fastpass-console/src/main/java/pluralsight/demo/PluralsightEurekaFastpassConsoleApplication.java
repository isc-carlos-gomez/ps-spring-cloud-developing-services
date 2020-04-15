package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PluralsightEurekaFastpassConsoleApplication {

  public static void main(final String[] args) {
    SpringApplication.run(PluralsightEurekaFastpassConsoleApplication.class, args);
  }
}