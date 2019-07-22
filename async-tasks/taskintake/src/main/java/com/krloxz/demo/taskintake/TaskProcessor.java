package com.krloxz.demo.taskintake;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class TaskProcessor {

  @Autowired
  private Source source;

  public void publishRequest(final String payload) {
    final String url = "maven://com.krloxz.demo:task:jar:1.0.0";
    final TaskLaunchRequest request = new TaskLaunchRequest(
        url, Arrays.asList(payload.split(",")), null, null, null);
    System.out.println("Task launch request created: " + request);

    final GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
    this.source.output().send(message);
  }

}
