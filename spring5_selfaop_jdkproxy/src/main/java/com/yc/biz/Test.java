package com.yc.biz;

import com.yc.LogAspect;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-12 19:19
 */
public class Test {
    public static void main(String[] args) {
        Student target=new StudentBizImpl(); //spring Ioc

        LogAspect la=new LogAspect(target);

        Object obj=la.createProxy();  //obj就是代理对象
        System.out.println(obj.toString());

        if(obj instanceof Student){
            Student s= (Student) obj;
            s.find("张三");  //jvm会感到这个s是一个proxy ，jvm就会调用这个proxy中的invoke

            s.add("李四");

            s.update("王五");
        }
    }
}
