package com.krloxz.demo.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RefreshScope
public class RateController {

  @Value("${rate}")
  private String rate;

  @Value("${lanecount}")
  private String lanecount;

  @Value("${tollstart}")
  private String tollstart;

  @Value("${connstring}")
  private String connstring;

  @GetMapping("/rate")
  public String getRate(final Model model) {
    model.addAttribute("rateamount", this.rate);
    model.addAttribute("lanes", this.lanecount);
    model.addAttribute("tollstart", this.tollstart);
    model.addAttribute("connstring", this.connstring);
    return "rateview";
  }

}
