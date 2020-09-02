package com.wxn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @RequestMapping(value = "/hi",method = RequestMethod.GET)
  public String hello(){
    return "hello world!";
  }
}
