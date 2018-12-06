/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.controller;

import com.example.demo.config.DemoProperties;
import com.example.demo.services.IService;
import com.example.demo.services.a.IAService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author suimi
 * @date 2018/5/30
 */
@Slf4j
@RestController public class TestController {
    @Autowired private DemoProperties properties;

    @Autowired private IService service;

    @Autowired private List<IAService> aservices;

    @GetMapping("properties/get") public String getProperties() {
        return ToStringBuilder.reflectionToString(properties);
    }

    @GetMapping("service") public String service() {
        return service.dosomthing();
    }

    @GetMapping("a") public String a() {
        log.info("process");
        return aservices.stream().map(s -> s.dosomthing()).collect(Collectors.joining(","));
    }

    @GetMapping("er") public void error() {
        throw new RuntimeException();
    }
}
