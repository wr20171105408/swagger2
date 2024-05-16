package com.wang.swagger2.demos.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// Swagger的配置类
/*@EnableSwagger2
@Configuration*/
public class SwaggerConfig1 {


    /**
     * 通过createRestApi函数创建Docket的Bean之后，
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * apis()函数扫描所有Controller中定义的API， 并产生文档内容（除了被@ApiIgnore指定的请求）
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                //指定包下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.demo.swagger.demos.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()

                        .title("业务模块API")
                        .description("用户")
                        .version("版本号: 1.0")
                        //.contact(new Contact("佚名","blog.bdqn.net","yiming@qq.com"))
                        .license("The Apache License")
                        //.licenseUrl("http://www.baidu.com")
                        .build());

        //license 和licenseUrl(许可访问地址)  可以不加
    }
}