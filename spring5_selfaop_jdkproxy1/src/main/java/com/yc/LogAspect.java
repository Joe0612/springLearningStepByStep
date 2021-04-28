package com.yc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-20 20:36
 */
public class LogAspect implements InvocationHandler {

    private Object target;

    public LogAspect(Object target){
        this.target=target;
    }

    public Object createProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的对象："+proxy.getClass());
        System.out.println("代理的方法:"+method);
        System.out.println("代理的对象组："+args);

        if(method.getName().startsWith("add")){
            log();
        }
        Object returnValue=method.invoke(target,args);
        return returnValue;
    }

    private void log(){
        System.out.println("=======before advice======");
        System.out.println("hello ,this is "+new Date());
        System.out.println("=========");
    }
}
