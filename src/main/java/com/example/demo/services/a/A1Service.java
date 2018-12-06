/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.services.a;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author suimi
 * @date 2018/5/30
 */

@Order(1)
@Service
@Slf4j
public class A1Service implements IAService {
    @Override public String dosomthing() {
        return "A1Service";
    }
}

