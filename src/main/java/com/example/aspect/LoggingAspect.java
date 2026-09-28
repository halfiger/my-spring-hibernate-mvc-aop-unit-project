package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    //pointcut for all methods in services
    @Pointcut ("execution(* com.example.service.*.*(..))")
    private void allServiceMethods () {}
}
