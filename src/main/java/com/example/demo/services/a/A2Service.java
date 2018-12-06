/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.services.a;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author suimi
 * @date 2018/5/30
 */

@Order(2)
@Service public class A2Service implements IAService {
    @Override public String dosomthing() {
        return "A2Service";
    }
}
