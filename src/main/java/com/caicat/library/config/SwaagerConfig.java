package com.caicat.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@SuppressWarnings("all")
public class SwaagerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo())
                        .groupName("开发者001：caicat")
                        .enable(true)//为false时关闭swagger,我们只在开发环境中去使用
                        .select()//使用过滤必须调用select方法
                        .paths(PathSelectors.ant("/**"))//设置对请求路径的访问,非这种请求没有对应的接口文档
                        .apis(RequestHandlerSelectors.basePackage("com.caicat.library.controller")) //过滤器,swagger只扫描那个包的接口
                        .build()//构建
                        ;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图书管理系统_单表版")
                .description("图书管理")
                .contact(new Contact("caicat","www.baidu.com","caicaiwwangyi@163.com"))
                .version("1.0")
                .build();
    }
}
