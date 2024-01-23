package com.example.spring_boot_whiskey.aspect;

import com.example.spring_boot_whiskey.dto.UserDto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class UserAspect {

    @Pointcut("within(com.example.spring_boot_whiskey.service.*)")  // save()   getAll()
    public void allMethodsPointcut(){};

    @Pointcut("execution(public * com.example.spring_boot_whiskey.service.UserService.save(..))")
    public void callAllMyServicePublic(){}   // save()  save(AnimalDto animalDto),  save(UserDto userDto)

    @Before("allMethodsPointcut()")
    public void loggingAdvice(){
        System.out.println("executing before method invoke");
    }

    @Before("callAllMyServicePublic()")
    public void beforeCallAllMethod(JoinPoint jp){
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));

        System.out.println("before "+jp+", args=["+args+"]");
    }

    @After("callAllMyServicePublic()")
    public void afterCallAllMethod(JoinPoint jp){
        System.out.println("after "+jp.getSignature().getName());
    }

    @Around("within(com.example.spring_boot_whiskey.service.*)")
    public List<UserDto> aroundAdvice(ProceedingJoinPoint joinPoint){
        log.info("\"Before invoking method \"+ joinPoint.getSignature()");

        Object value=null;
        try{
            value=joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }

        System.out.println("After invoking method."+value);
        return (List<UserDto>) value;
    }

}
