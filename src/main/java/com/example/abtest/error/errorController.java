package com.example.abtest.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class errorController {


  @RequestMapping("/error/500")
  public String error_500() {
    return "/error/500";
  }

  @RequestMapping("/error/404")
  public String error_400() {
    return "/error/404";
  }
}