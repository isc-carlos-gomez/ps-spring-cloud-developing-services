package com.krloxz.demo.tasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class TasksinkApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TasksinkApplication.class, args);
  }

}
