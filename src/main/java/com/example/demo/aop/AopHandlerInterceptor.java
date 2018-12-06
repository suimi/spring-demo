/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author suimi
 * @date 2018/12/6
 */
@Slf4j
public class AopHandlerInterceptor implements HandlerInterceptor {
    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        log.info("afterCompletion");

    }
}
