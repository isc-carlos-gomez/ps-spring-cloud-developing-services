package com.krloxz.demo.dataservice2;

import java.util.Hashtable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dataservice2Application {

  public static void main(final String[] args) {
    SpringApplication.run(Dataservice2Application.class, args);
  }

  @RequestMapping(value = "/customer/{cid}/vehicledetails", method = RequestMethod.GET)
  public @ResponseBody String getCustomerVehicleDetails(@PathVariable final Integer cid) {

    final Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
    vehicles.put(100, "Lincoln Continental; Plate SNUG30");
    vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
    vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

    final String result = vehicles.get(cid);

    return result;
  }
}
