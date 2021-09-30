package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

  @Before("execution(* com.example.demo.service.DemoService.*(..)) && @args(com.example.demo.annotations.DemoAnnotation)")
  public void dummyBeforeAdvice() {
    System.out.println("Inside before advice logic");
  }

  @After("execution(* com.example.demo.service.DemoService.*(..)) && args(java.lang.String)")
  public void dummyAfterFinallyAdvice() {
    System.out.println("Inside after finally advice logic.");
  }

  @AfterReturning(pointcut = "@within(com.example.demo.annotations.DemoAnnotation)", returning = "returnedValue")
  public void dummyAfterReturningAdvice(String returnedValue) {
    System.out.println("Inside after return advice logic. Returned value is : " + returnedValue);
  }

  @AfterThrowing(pointcut = "execution(* com.example.demo.service.DemoService.*(..))", throwing = "ex")
  public void dummyAfterThrowingAdvice(NullPointerException ex) {
    System.out.println(
        "Inside after throwing advice logic. Exception was thrown with message:" + ex.getMessage());
  }

  @Around("@annotation(com.example.demo.annotations.DemoAnnotation)")
  public Object dummyAfterFinalAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("Inside around advice: Before Logic.");
    Object obj = proceedingJoinPoint.proceed();
    System.out.println("Inside around advice: After Logic.");

    return obj;
  }
}
