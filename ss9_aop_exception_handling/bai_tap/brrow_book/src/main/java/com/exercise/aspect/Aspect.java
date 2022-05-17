package com.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Pointcut("execution(* com.exercise.controller.BookController.borrow*(..))")
    public void allMethodCallPointCut() {
    }

    @Before("allMethodCallPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.err.println(" Start time : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }

    @AfterReturning("allMethodCallPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("  End time : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }

}
