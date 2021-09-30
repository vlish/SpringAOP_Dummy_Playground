package com.example.demo.service;

import com.example.demo.annotations.DemoAnnotation;
import com.example.demo.model.Model;
import org.springframework.stereotype.Service;

@Service
@DemoAnnotation
public class DemoService {

  public void demoJoinPointBefore(Model model) {
    System.out.println("Inside join point method(before)");
  }

  public void demoJoinPointAfter(String param) {
    System.out.println("Inside join point method(after)");
  }

  public String demoJoinPointAfterReturn() {
    System.out.println("Inside join point method(after return)");
    return "result";
  }

  public void demoJoinPointAfterThrow() {
    System.out.println("Inside join point method(after throw)");
    String arg = null;
    arg.equals("");
  }

  @DemoAnnotation
  public void demoJoinPointAround() {
    System.out.println("Inside join point method(around)");
  }

}
