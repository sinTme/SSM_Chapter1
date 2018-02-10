package com.powek.common.interceptor;

import com.powek.common.anotation.authen;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("@annotation(authen)")
    public void before(JoinPoint joinPoint, authen authen)
    {
        String name = authen.name();
    }

    public void after()
    {

    }
}
