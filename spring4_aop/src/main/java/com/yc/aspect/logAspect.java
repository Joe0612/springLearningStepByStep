package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-09 19:34
 */
@Aspect  // 切面类: 你要增强的功能写到这里
@Component   //IOC注解  以实现让spring托管的功能
@Order(value = 100)
public class logAspect {

    //切入点的声明  pointcut signature
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")  //切入点表达式：哪些方法上加增强
    private void add(){
    }

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*())")  //切入点表达式 哪里方法上加增强
    private void update(){
    }

    @Pointcut("add() || update()")
    private void addAndUpdate(){}


    //增强的声明
    @Before("com.yc.aspect.logAspect.add()")
    public void log(){
        System.out.println("==============前置增强的日志==================");
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr=sdf.format(d);
        System.out.println("执行时间为："+dstr);
        System.out.println("===============前置增强的日志结果");
    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("========compute====进到  增强了");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();  //目标类的目标方法
        long end=System.currentTimeMillis();
        System.out.println("compute1要退出增强了");
        System.out.println("==========这个方法运行的时长为："+(end-start));
        return retVal;
    }
}
