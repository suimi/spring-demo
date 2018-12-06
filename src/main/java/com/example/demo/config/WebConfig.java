/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.config;

import com.example.demo.aop.AopHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author suimi
 * @date 2018/12/6
 */
@Configuration public class WebConfig extends WebMvcConfigurerAdapter {


    @Override public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new AopHandlerInterceptor()).addPathPatterns("/**");
    }
}
