package com.yc;

import com.yc.springframework.stereotype.MyComponentScan;
import com.yc.springframework.stereotype.MyConfiguration;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-05 12:00
 */
@MyConfiguration
@MyComponentScan(basePackages = {"com.yc.bean","com.yc.biz","com.yc.dao"})
public class MyAppConfig {

//    @MyBean
//    public HelloWorld hw(){   //method.invoke(MyAppConfig对象 ,xxxx)
//        return new HelloWorld();
//    }
//
//    @MyBean
//    public HelloWorld hw2(){
//        return new HelloWorld();
//    }

}
