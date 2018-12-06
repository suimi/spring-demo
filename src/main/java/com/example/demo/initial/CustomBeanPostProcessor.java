/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author suimi
 * @date 2018/12/5
 */
@Component
@Slf4j public class CustomBeanPostProcessor implements BeanFactoryPostProcessor, BeanPostProcessor {

    //No active
    @PostConstruct public void init() {
        log.info("Post processor PostConstruct");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {
        log.info("{}.BeanFactoryPostProcessor.postProcessBeanFactory, bean:{}", this.getClass().getSimpleName(), this);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}.BeanPostProcessor.postProcessBeforeInitialization,beanName:{}, bean:{}",
            this.getClass().getSimpleName(), beanName, bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}.BeanPostProcessor.postProcessAfterInitialization, beanName:{}, bean:{}",
            this.getClass().getSimpleName(), beanName, bean);
        return bean;
    }
}
