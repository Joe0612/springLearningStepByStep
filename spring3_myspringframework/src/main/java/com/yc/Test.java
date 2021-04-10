package com.yc;

import com.yc.biz.StudentBizImpl;
import com.yc.springframework.context.MyAnnotationConfigApplicationContext;
import com.yc.springframework.context.MyApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-05 11:59
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException, ClassNotFoundException {
        MyApplicationContext ac=new MyAnnotationConfigApplicationContext(MyAppConfig.class);
//        HelloWorld hw= (HelloWorld) ac.getBean("hw");
//        hw.show();
        StudentBizImpl hw= (StudentBizImpl) ac.getBean("studentBizImpl");
        hw.add("abc");
    }
}
