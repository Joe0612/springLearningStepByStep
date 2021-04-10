package com.yc.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-04 15:21
 */
@Component  //只要加了这个注解 则这个类可以被spring容器托管
@Lazy
public class HelloWorld {  //创建这个类的对象???
    public HelloWorld(){ System.out.println("无参构造方法"); }

    public void hello(){ System.out.println("hello world"); }
}
