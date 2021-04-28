package com.yc.tx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-26 19:00
 */
@Configuration
@EnableSwagger2 //启用swagger 注解解析器
public class Swagger2Config {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "${swagger.enabled}")  //可通过@Value获取配置信息复习  @Enviroment  @Value  @ConfigurationProperties
    Boolean swaggerEnabled;
    
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled).select()//是否开启
                .apis(RequestHandlerSelectors.basePackage("com.yc")) //扫描包路径，只要这些包中的类配有swagger注解，则启用这些注解
                .paths(PathSelectors.any()).build().pathMapping("/");  //指定路径处理PathSelectors.any()代表所有路径
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("银行存取操作接口")
                .description("springboot|swagger")
                //作者信息
                .contact(new Contact("ql","www.baidu.com","1933547552@qq.com"))
                .version("1.0.0")
                .build();
    }
}
