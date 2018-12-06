/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.config;

import com.example.demo.services.AService;
import com.example.demo.services.IService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suimi
 * @date 2018/5/30
 */
@ConditionalOnProperty(prefix = "higgs.trust", name = "consensus", havingValue = "copycat") @Configuration
public class AConfig {

    @Bean IService createService() {
        return new AService();
    }
}
