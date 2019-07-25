package com.krloxz.demo.secureservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SecureserviceApplication {

  public static void main(final String[] args) {
    SpringApplication.run(SecureserviceApplication.class, args);
  }

  @GetMapping("/tolldata")
  public List<TollUsage> getTollData() {

    final List<TollUsage> tolls = new ArrayList<TollUsage>();
    tolls.add(new TollUsage("200", "station150", "B65GT1W", "2016-09-30T06:31:22"));
    tolls.add(new TollUsage("201", "station119", "AHY673B", "2016-09-30T06:32:50"));
    tolls.add(new TollUsage("202", "station150", "ZN2GP0", "2016-09-30T06:37:01"));

    return tolls;
  }

  public static class TollUsage {

    public String Id;
    public String stationId;
    public String licensePlate;
    public String timestamp;

    public TollUsage() {}

    public TollUsage(final String id, final String stationid, final String licenseplate,
        final String timestamp) {
      this.Id = id;
      this.stationId = stationid;
      this.licensePlate = licenseplate;
      this.timestamp = timestamp;
    }

  }

}
