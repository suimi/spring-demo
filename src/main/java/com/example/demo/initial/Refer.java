/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.initial;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author suimi
 * @date 2018/6/14
 */
@ToString
@Service @Slf4j public class Refer
    implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean, ApplicationContextAware,
    ApplicationListener<SpringApplicationEvent> {

    private String test = "test";

    public Refer() {
        log.info("{}.Construct, bean:{}", this.getClass().getSimpleName(), this);
    }

    @Override public void setBeanName(String s) {
        log.info("{}.BeanNameAware.setBeanName:{}, bean:{}", this.getClass().getSimpleName(), s, this);
    }

    @Override public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("{}.BeanFactoryAware.setBeanFactory, bean:{}", this.getClass().getSimpleName(), this);
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("{}.ApplicationContextAware.setApplicationContext, bean:{}", this.getClass().getSimpleName(), this);
    }
    //BeanPostProcessor.postProcessBeforeInitialization

    @PostConstruct public void init() {
        log.info("{}.PostConstruct, bean:{}", this.getClass().getSimpleName(), this);
    }

    @Override public void afterPropertiesSet() throws Exception {
        log.info("{}.InitializingBean.afterPropertiesSet, bean:{}", this.getClass().getSimpleName(), this);
    }

    //BeanPostProcessor.postProcessAfterInitialization

    @Override public void onApplicationEvent(SpringApplicationEvent event) {
        log.info("{}.ApplicationListener.event:{}, bean:{}", this.getClass().getSimpleName(), event, this);
    }

    @Override public void destroy() throws Exception {
        log.info("{}.DisposableBean.destroy, bean:{}", this.getClass().getSimpleName(), this);
    }
}
