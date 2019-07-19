package com.krloxz.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TaskApplication.class, args);
  }

  @Bean
  public TollProcessingTask tollProcessingTask() {
    return new TollProcessingTask();
  }

  private static class TollProcessingTask implements CommandLineRunner {

    @Override
    public void run(final String... arguments) throws Exception {
      if (arguments != null) {
        System.out.println("Arguments length: " + arguments.length);

        final String stationId = arguments[1];
        final String licensePlate = arguments[2];
        final String timestamp = arguments[3];
        System.out.println("Station ID is " + stationId + ", plate is " + licensePlate
            + ", timestamp is " + timestamp);
      }
    }

  }

}
