package com.yc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-04 19:35
 */
@Configuration
@ComponentScan(basePackages = "com.yc")
@EnableAspectJAutoProxy  //启用aspectJ支持
public class AppConfig {

//    @Bean
//    public StudentBizImpl studentBizImpl(){
//        return new StudentBizImpl();
//    }
}
