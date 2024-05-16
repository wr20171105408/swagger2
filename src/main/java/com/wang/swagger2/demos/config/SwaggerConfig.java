package com.wang.swagger2.demos.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket ProductApi() {
        /*List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("参数错误").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("没有认证").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("没有没有访问权限").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求成功").responseModel(new ModelRef("ApiError")).build());*/
        return new Docket(DocumentationType.SWAGGER_2)
               /* .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)*/
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
               // .apis(RequestHandlerSelectors.basePackage("com.wang.swagger2.demos.controller")) //指定扫描包
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) // 扫描所有有注解的api，用这种方式更灵活

                .build()
                .apiInfo(productApiInfo())
                .globalOperationParameters(setGlobalParameters())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }
    /**
     * 简单设置全局参数
     *
     * @return
     */
    private List<Parameter> setGlobalParameters() {
        List<Parameter> globalParameterList = new ArrayList<>();

        //Header中必需 token参数。非必填，传空也可以，一般业务登录拦截器校验 token是否合法
        ParameterBuilder tokenBuilder = new ParameterBuilder();
        tokenBuilder.name("token").description("用户 TOKEN参数")
                .required(false)// 非必填
                .modelRef(new ModelRef("string"))
                .parameterType("header");
        globalParameterList.add(tokenBuilder.build());

        return globalParameterList;
    }

    /**
     * 自定义一个Apikey
     * 这是一个包含在header中键名为Authorization的JWT标识
     */
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList= new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("token", "token", "header")); // 配置全局token
        return apiKeyList;
    }
    // 这里我们使用ApiKey作为安全模式，它由名称mykey标识
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    /**
     * 配置JWT的SecurityContext 并设置全局生效
     */
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("XXX数据接口文档",
                "文档描述",
                "版本",
                "服务条款Url",
                "联系人邮箱",
                "许可证",
                "许可证url");
        return apiInfo;
    }


}
