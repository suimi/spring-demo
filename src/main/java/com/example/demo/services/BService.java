/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.services;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author suimi
 * @date 2018/5/30
 */
//@Primary
//@Service
public class BService implements IService {
    @Override public String dosomthing() {
        return "BService";
    }
}
