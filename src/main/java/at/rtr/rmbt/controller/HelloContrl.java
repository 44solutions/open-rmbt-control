package at.rtr.rmbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class HelloContrl {

  @Autowired
  private ApplicationContext applicationContext;
  @GetMapping("/hello")
  public String hello() {
//    RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(
//        RequestMappingHandlerMapping.class);
    return "hello";
  }
}
