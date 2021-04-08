package com.yc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-04 19:35
 */
@Configuration
@ComponentScan(basePackages = "com.yc")
public class AppConfig {

//    @Bean
//    public StudentBizImpl studentBizImpl(){
//        return new StudentBizImpl();
//    }
}
