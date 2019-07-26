package com.krloxz.demo.dataservice1;

import java.util.Hashtable;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dataservice1Application {

  public static void main(final String[] args) {
    SpringApplication.run(Dataservice1Application.class, args);
  }

  @RequestMapping(value = "/customer/{cid}/contactdetails", method = RequestMethod.GET)
  public @ResponseBody String getCustomerContactDetails(@PathVariable final Integer cid)
      throws InterruptedException {

    // add arbitrary latency
    final Random r = new Random();
    final int multiplier = r.nextInt(5) * 1000;
    System.out.println("multiplier: " + multiplier);
    Thread.sleep(multiplier);


    final Hashtable<Integer, String> customers = new Hashtable<Integer, String>();
    customers.put(100, "Beverly Goldberg");
    customers.put(101, "Dave Kim");
    customers.put(102, "Lainey Lewis");

    final String result = customers.get(cid);

    return result;
  }
}
