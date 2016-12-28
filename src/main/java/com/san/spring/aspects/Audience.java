package com.san.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by AnNN1 on 12/26/2016.
 */

@Aspect
public class Audience {

    @Pointcut("execution(** com.san.spring.bean.CompactDisc.play(..))")
    public void listen() {}

    @Before("listen()")
    public void insertDisc() {
        System.out.println("Insert Disc...");
    }

    @After("listen()")
    public void ejectDisc() {
        System.out.println("Ejecting disc ....");
    }

    @Around("listen()")
    public void checkDisc(ProceedingJoinPoint jp) {
        try {
            System.out.println("Checking disc to insert ....");
            jp.proceed();
            System.out.println("\nChecking disc to eject ....");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }

}
