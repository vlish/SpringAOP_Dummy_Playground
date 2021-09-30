package com.example.demo;

import com.example.demo.model.Model;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude =
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
)
@RequiredArgsConstructor
public class DemoApplication implements ApplicationRunner {

  private final DemoService demoService;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    demoService.demoJoinPointBefore(new Model());
    demoService.demoJoinPointAfter("param");
    demoService.demoJoinPointAfterReturn();
    demoService.demoJoinPointAround();
    demoService.demoJoinPointAfterThrow();
  }
}
