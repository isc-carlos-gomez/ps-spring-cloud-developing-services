package com.krloxz.demo.taskintake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskProcessor processor;

  @PostMapping("/tasks")
  public String launchTask(@RequestBody final String arguments) {
    this.processor.publishRequest(arguments);
    System.out.print("Request published");
    return "success";
  }

}
