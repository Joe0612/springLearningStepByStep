package com.yc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-10 19:51
 */
public class LogAspectCglib implements MethodInterceptor {
    private Object target;

    public LogAspectCglib(Object target){
        this.target=target;
    }

    public Object createProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理类的对象："+o.getClass());
        System.out.println("目标类的方法："+method);
        System.out.println("方法中的参数："+objects);
        System.out.println("要代理的方法："+methodProxy);

        if(method.getName().startsWith("add")){
            log();
        }
        Object returnValue=method.invoke(this.target,objects);

        return returnValue;
    }

        private void log() {
            System.out.println("=======before advice======");
            System.out.println("hello ,this is " + new Date());
            System.out.println("=========");
        }
}
