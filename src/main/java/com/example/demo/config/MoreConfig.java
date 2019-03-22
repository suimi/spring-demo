/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author suimi
 * @date 2018/5/30
 */
@ConditionalOnProperty(prefix = "higgs.trust", name = {"A", "B"}, havingValue = "true", matchIfMissing = true)
@Configuration public class MoreConfig implements InitializingBean {

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("more config");
    }
}
