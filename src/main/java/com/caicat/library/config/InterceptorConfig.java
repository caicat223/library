package com.caicat.library.config;

import com.caicat.library.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      JWTInterceptor jwtInterceptor = new JWTInterceptor();
        registry.addInterceptor(jwtInterceptor)
                            .addPathPatterns("/bookManage/**")
                            .excludePathPatterns("/login/**");
    }

}
