package com.testApp.testAppDocEditor.configuration;

import com.testApp.testAppDocEditor.service.DockFileService;
import com.testApp.testAppDocEditor.web.interceptor.NameInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(nameInterceptor()).addPathPatterns("/app/v1/docks/create");
    }

    @Bean
    public NameInterceptor nameInterceptor() {
        return new NameInterceptor();
    }

}
