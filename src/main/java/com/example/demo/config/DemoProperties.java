/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author suimi
 * @date 2018/5/30
 */
@Getter @Setter @ConfigurationProperties(prefix = "demo") @Configuration public class DemoProperties implements Serializable {

    private static final long serialVersionUID = -7988794798056205695L;
    private String ip;

    private int port = 7000;

    private User leader;

    private Map<String, User> users;

    private List<User> followers;

    private String test;

    private boolean isDemo = true;

    private boolean verify = true;

    @Getter @Setter public static class User {
        private String name;
        private String id;
    }
}
