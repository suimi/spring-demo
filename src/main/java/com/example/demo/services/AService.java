/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.services;

import org.springframework.stereotype.Service;

/**
 * @author suimi
 * @date 2018/5/30
 */

public class AService implements IService {
    @Override public String dosomthing() {
        return "AService";
    }
}
