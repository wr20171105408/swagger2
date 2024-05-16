package com.wang.swagger2.demos.config;

import com.wang.swagger2.demos.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录、注册不拦截
        registry.addInterceptor(loginInterceptor)
                // swagger2之源不拦截
                .excludePathPatterns("/swagger-resources/**", "/webjars/**",
                        "/v2/**", "/swagger-ui.html/**", "/doc.html/**")
                // 自己单独接口不拦截
                .excludePathPatterns("/user/login","/user/getUsers");
    }
}
